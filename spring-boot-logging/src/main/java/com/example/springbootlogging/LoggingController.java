package com.example.springbootlogging;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/log")
    public Map<String, Object> hello() {
        Map<String, Object> result = new HashMap<>();
        result.put("name", "Stephen");
        logger.info("This is info message");
        logger.warn("This is warn message");
        logger.error("This is error message");
        return result;
    }
}