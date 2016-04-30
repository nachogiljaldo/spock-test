package com.gilsoft.user

import com.gilsoft.test.SpringSpec
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDate

import static org.hamcrest.CoreMatchers.*
import static org.hamcrest.core.IsNull.notNullValue
import static spock.util.matcher.HamcrestSupport.that

class UserDaoISpec extends SpringSpec {
    @Autowired
    def UserDao userDao

    def ".save(user) saves to the database"() {
        given:
        def user = new User("John", "Doe", LocalDate.of(1982, 8, 30))

        when:
        userDao.save(user)
        userDao.entityManager.flush()
        userDao.entityManager.clear()
        def userFromDB = userDao.getById(user.id)

        then:
        that userFromDB, notNullValue()
        that userFromDB, is(not(sameInstance(user)))
        that userFromDB.id, equalTo(user.id)
        that userFromDB.firstName, equalTo(user.firstName)
        that userFromDB.lastName, equalTo(user.lastName)
        that userFromDB.birthDay, equalTo(user.birthDay)
    }
}
