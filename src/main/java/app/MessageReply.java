package app;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

public class MessageReply {
	@JmsListener(destination = "queue.foo")
	@SendTo(value = "queue.bar")
	public String process(String receive) {
		System.out.println("***** MessageReply:" + receive);
		return "I am fine.";
	}
}