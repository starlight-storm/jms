package config;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.springframework.jms.listener.adapter.MessagingMessageListenerAdapter;
import org.springframework.jms.support.JmsUtils;

public class MyMessagingMessageListenerAdapter extends MessagingMessageListenerAdapter {

	@Override
	protected void sendResponse(Session session, Destination destination, Message response) throws JMSException {
		MessageProducer producer = session.createProducer(destination);
		try {
			postProcessProducer(producer, response);
			//producer.send(response);
			System.out.println("##### sendResponse");
			producer.send(response, producer.getDeliveryMode(), producer.getPriority(), 5000);			
		}
		finally {
			JmsUtils.closeMessageProducer(producer);
		}
	}

	
	
	
}
