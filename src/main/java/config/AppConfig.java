package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import app.MessageReply;
import app.Sender;

@Configuration
public class AppConfig {

	@Bean
	public MessageReply messageReply() {
		return new MessageReply();
	}
	
	@Bean
	public Sender sender(JmsTemplate jmsTemplate) {
		return new Sender();
	}
	
}
