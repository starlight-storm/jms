package app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.JmsConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, JmsConfig.class})
public class SenderTest {
	@Autowired
    ConfigurableApplicationContext context;
	
	@Autowired
	private Sender sender;
	
	@Test
	public void testSend() throws Exception {
		sender.send();
		context.close();
	}
	
}
