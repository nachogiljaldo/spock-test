package com.gilsoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallerService.class);

    private CalledService calledService;

    public CallerService(CalledService calledService) {
        this.calledService = calledService;
    }

    public void execute(String parameter) {
        boolean result = calledService.execute(parameter);
        if (result) {
            LOGGER.debug("Successful execution for parameter {}", parameter);
        } else {
            LOGGER.warn("Unsuccessful execution for parameter {}", parameter);
        }
    }

    public int moreSophisticatedExecute(String parameter) {
        boolean result = calledService.execute(parameter);
        return result ? 1 : 0;
    }
}
