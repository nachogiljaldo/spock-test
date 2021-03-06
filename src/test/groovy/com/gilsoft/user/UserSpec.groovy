package com.gilsoft.user

import spock.lang.Specification
import spock.lang.Unroll

import static java.time.LocalDate.now

class UserSpec extends Specification {
    def "should have a first name"() {
        given: "a user"
        // [] is Groovy literal for List and is infered
        def user = new User("John", "Doe", now())

        when: "I fetch name"
        def firstName = user.firstName

        then: "name is correct"
        assert firstName == "John"
    }

    @Unroll("user born on #user.birthDay should have age #expectedAge")
    def "should calculate age"(user, expectedAge) {
        expect:
        assert user.age == expectedAge

        where:
        user                                     |expectedAge
        new User("John", "Doe", now())           |0
        new User("John", "Doe", now().minusDays(1)) |0
        new User("John", "Doe", now().minusYears(1)) |1
        new User("John", "Doe", now().minusYears(1).plusDays(1)) |0
        new User("John", "Doe", now().minusYears(1).minusDays(1)) |1
    }
}
