package com.stackify.mongodb;

import com.stackify.mongodb.config.MongoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MongoConfig.class})
public class MongodbApplicationTests {

	Logger logger = LoggerFactory.getLogger(MongodbApplicationTests.class);

	@Test
	public void contextLoads() {
	}

}
