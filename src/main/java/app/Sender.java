package app;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@RequestMapping(value = "/send")
	void execute(@RequestParam String msg) throws Exception {
		System.out.println("***** Msg: " + msg);
		send();
	}
	
	public void send() throws Exception {
		System.out.println("***** START send");
		
//		MessageCreator messageCreator = new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return (session).createTextMessage("How are you?");
//            }
//        };
//		jmsTemplate.send("queue.foo", messageCreator);
				
		jmsTemplate.convertAndSend("queue.foo", "How are you?");
		
		TextMessage msg = (TextMessage)jmsTemplate.receive("queue.bar");		
		
		System.out.println("***** Sender:"+msg.getText());
		System.out.println("***** exp:"+msg.getJMSExpiration());
	}
}
