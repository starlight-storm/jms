package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import config.AppConfig;
import config.JmsConfig;

@SpringBootApplication
@EnableAutoConfiguration
@Import({AppConfig.class, JmsConfig.class})
public class JmsSampleRun {
	public static void main(String[] args) {
		SpringApplication.run(JmsSampleRun.class, args);
	}
}