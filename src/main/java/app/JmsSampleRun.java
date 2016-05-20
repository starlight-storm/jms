package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.context.annotation.Import;

import config.AppConfig;
import config.JmsConfig;

@SpringBootApplication(exclude = { JmsAutoConfiguration.class })
@Import({ AppConfig.class, JmsConfig.class })
public class JmsSampleRun {
	public static void main(String[] args) {
		SpringApplication.run(JmsSampleRun.class, args);
	}
}