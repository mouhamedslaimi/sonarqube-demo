package com.devops.sonarqubedemo;

import com.devops.sonarqubedemo.controller.MessageController;
import com.devops.sonarqubedemo.entities.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * The type Sonarqube demo application tests.
 */
@SpringBootTest
class SonarqubeDemoApplicationTests {

	@Autowired
	private MessageController controller;

	/**
	 * Context loads.
	 */
	@Test
	void contextLoads() {
	}

	/**
	 * Test get message.
	 */
	@Test
	void testGetMessage() {
		List<Message> message = controller.getMessage();
		Assertions.assertNotNull(message);
	}
}
