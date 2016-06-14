package org.google;

import org.google.config.CrudappApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrudappApplication.class)
@WebAppConfiguration
public class CrudappApplicationTests {

	@Test
	public void contextLoads() {
	}

}
