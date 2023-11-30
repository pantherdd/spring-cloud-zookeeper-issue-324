package com.example.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    @Value("${message:No message}")
    private String message;

    @RequestMapping("/message")
    public String getMessage() {
        return message;
    }
}
