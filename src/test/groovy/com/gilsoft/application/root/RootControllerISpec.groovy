package com.gilsoft.application.root

import com.gilsoft.test.SpringSpec

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class RootControllerISpec extends SpringSpec {

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
}
