package com.devops.sonarqubedemo.service;

import com.devops.sonarqubedemo.entities.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl {

	public List<Message> getMessage() {
		return  List.of(new Message("DevOps"));
	}


}
