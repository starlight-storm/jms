package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;

import config.AppConfig;
import config.JmsConfig;

@SpringBootApplication
@ContextConfiguration(classes={AppConfig.class, JmsConfig.class})
public class JmsSampleRun {
	public static void main(String[] args) {
		SpringApplication.run(JmsSampleRun.class, args);
	}
}