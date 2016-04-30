package com.gilsoft.application.root

import com.gilsoft.application.App
import org.springframework.beans.BeansException
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@TestExecutionListeners([DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class])
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = App.class)
@WebAppConfiguration
@IntegrationTest
class RootControllerSpec extends Specification implements ApplicationContextAware {
    def ctx

    def mvc() {
        webAppContextSetup((WebApplicationContext) ctx).build();
    }

    def "/?query=error should return 0"() {
        given:
        def parameter = "error"

        when:
        def result = mvc().perform(get("/").accept(APPLICATION_JSON).param("query", parameter))
                .andExpect(status().isOk())
                .andReturn();

        then:
        assert result.response.getContentAsString() == "0"
    }

    def "/?query=other should return 1"() {
        given:
        def parameter = "other"

        when:
        def result = mvc().perform(get("/").accept(APPLICATION_JSON).param("query", parameter))
                .andExpect(status().isOk())
                .andReturn();

        then:
        assert result.response.getContentAsString() == "1"
    }

    @Override
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
