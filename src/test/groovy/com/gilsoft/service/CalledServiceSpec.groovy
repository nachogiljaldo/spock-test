package com.gilsoft.service

import spock.lang.Specification

class CalledServiceSpec extends Specification {
    def calledService = new CalledService();

    def "should return false if parameter 'error'"() {
        given:
        def parameter = "error"

        when:
        def result = calledService.execute(parameter)

        then:
        assert !result
    }

    def "should return true if parameter is not 'error'"() {
        given:
        def parameter = "something else"

        when:
        def result = calledService.execute(parameter)

        then:
        assert result
    }

    def "should return true if parameter is null"() {
        given:
        def parameter = null

        when:
        def result = calledService.execute(parameter)

        then:
        assert result
    }
}
