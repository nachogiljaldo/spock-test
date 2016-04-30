package com.gilsoft.test

import com.gilsoft.App
import org.springframework.beans.BeansException
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = App.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
@Rollback
abstract class SpringSpec extends Specification implements ApplicationContextAware {
    def ctx

    def mvc() {
        webAppContextSetup((WebApplicationContext) ctx).build();
    }

    @Override
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
