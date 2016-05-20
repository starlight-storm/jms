package config;

import org.springframework.jms.config.MethodJmsListenerEndpoint;
import org.springframework.jms.listener.adapter.MessagingMessageListenerAdapter;

public class MyMethodJmsListenerEndpoint extends MethodJmsListenerEndpoint {

	@Override
	protected MessagingMessageListenerAdapter createMessageListenerInstance() {
		System.out.println("##### createMessageListenerInstance");
		return new MyMessagingMessageListenerAdapter();
	}
}