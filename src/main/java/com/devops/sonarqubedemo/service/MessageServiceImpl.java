package com.devops.sonarqubedemo.service;

import com.devops.sonarqubedemo.entities.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Message service.
 */
@Service
public class MessageServiceImpl {

	/**
	 * Gets message.
	 *
	 * @return the message
	 */
	public List<Message> getMessage() {
		return  List.of(new Message("DevOps"));
	}


}
