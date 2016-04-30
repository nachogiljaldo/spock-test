package com.gilsoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CalledService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalledService.class);

    public boolean execute(String testParameter) {
        LOGGER.debug("Received parameter {}", testParameter);
        return !"error".equals(testParameter);
    }
}
