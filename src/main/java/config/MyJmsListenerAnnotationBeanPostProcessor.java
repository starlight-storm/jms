package config;

import org.springframework.jms.annotation.JmsListenerAnnotationBeanPostProcessor;
import org.springframework.jms.config.MethodJmsListenerEndpoint;

public class MyJmsListenerAnnotationBeanPostProcessor extends JmsListenerAnnotationBeanPostProcessor {

	@Override
	protected MethodJmsListenerEndpoint createMethodJmsListenerEndpoint() {
		System.out.println("##### createMethodJmsListenerEndpoint");
		return new MyMethodJmsListenerEndpoint();
	}
}
