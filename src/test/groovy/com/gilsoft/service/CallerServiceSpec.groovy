package com.gilsoft.service

import spock.lang.Specification
import static org.hamcrest.CoreMatchers.*

class CallerServiceSpec extends Specification {
    def calledService = Mock(CalledService)
    def callerService = new CallerService(calledService)

    def ".execute -> should forward parameter to method"() {
        given:
        def parameter = "parameter"

        when:
        callerService.execute(parameter)

        then:
        1 * calledService.execute(parameter)
    }

    // This could be also tested with a data driven approach, it's just for learning purposes
    def ".moreSophisticatedExecute -> should return 1 if service returns true"() {
        given:
        def parameter = "parameter"
        calledService.execute(parameter) >> true

        when:
        def result = callerService.moreSophisticatedExecute(parameter)

        then:
        result is(1)
    }

    def ".moreSophisticatedExecute -> should return 0 if service returns false"() {
        given:
        def parameter = "parameter"
        calledService.execute(parameter) >> false

        when:
        def result = callerService.moreSophisticatedExecute(parameter)

        then:
        result is(0)
    }
}
