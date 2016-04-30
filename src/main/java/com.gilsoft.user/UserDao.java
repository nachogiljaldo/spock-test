package com.gilsoft.user;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
