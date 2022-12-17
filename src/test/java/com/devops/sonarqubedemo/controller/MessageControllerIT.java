package com.devops.sonarqubedemo.controller;

import com.devops.sonarqubedemo.entities.Message;
import com.devops.sonarqubedemo.service.MessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Message controller it.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MessageServiceImpl messageService;

    /**
     * Registration works through all layers.
     *
     * @throws Exception the exception
     */
    @Test
    void registrationWorksThroughAllLayers() throws Exception {
        Message message = new Message("DevOps");

        mockMvc.perform(get("/message/")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*].message").value(hasItem("DevOps")));

    }
}
