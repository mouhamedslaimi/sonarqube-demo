package com.devops.sonarqubedemo.controller;

import com.devops.sonarqubedemo.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.sonarqubedemo.service.MessageServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageServiceImpl service;
	 
	@GetMapping("/")
	public List<Message> getMessage() {
		return service.getMessage();
	}
}
