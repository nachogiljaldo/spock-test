package com.gilsoft.user

import com.gilsoft.App
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import java.time.LocalDate

import static org.hamcrest.core.IsNull.notNullValue
import static org.hamcrest.CoreMatchers.equalTo
import static spock.util.matcher.HamcrestSupport.*

@TestExecutionListeners([DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class])
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = App.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
@Rollback
class UserDaoISpec extends Specification {
    @Autowired
    def UserDao userDao

    def ".save(user) saves to the database"() {
        given:
        def user = new User("John", "Doe", LocalDate.of(1982, 8, 30))

        when:
        userDao.save(user)
        def userFromDB = userDao.getById(user.id)

        then:
        that userFromDB, notNullValue()
        that userFromDB.id, equalTo(user.id)
        that userFromDB.firstName, equalTo(user.firstName)
        that userFromDB.lastName, equalTo(user.lastName)
        that userFromDB.birthDay, equalTo(user.birthDay)
    }
}
