package app;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping(value = "/send")
	void execute() throws Exception {
		send();
	}

	public void send() throws Exception {
		jmsTemplate.convertAndSend("queue.foo", "How are you?");
		TextMessage msg = (TextMessage) jmsTemplate.receive("queue.bar");
		System.out.println("***** Sender:" + msg.getText());
		System.out.println("***** exp:" + msg.getJMSExpiration());
	}
}
