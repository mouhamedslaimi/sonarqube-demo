package com.devops.sonarqubedemo;

import com.devops.sonarqubedemo.controller.MessageController;
import com.devops.sonarqubedemo.entities.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SonarqubeDemoApplicationTests {

	@Autowired
	private MessageController controller;
	
	@Test
	void contextLoads() {
	}

	@Test
	void testGetMessage() {
		List<Message> message = controller.getMessage();
		Assertions.assertNotNull(message);
	}
}
