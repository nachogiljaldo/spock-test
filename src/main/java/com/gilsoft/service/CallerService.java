package com.gilsoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallerService.class);

    @Autowired
    private CalledService calledService;

    public CallerService() {
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

    public void setCalledService(CalledService calledService) {
        this.calledService = calledService;
    }
}
