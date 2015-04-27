package com.alpha.dao;

import com.alpha.models.User;

import java.util.List;

/**
 * Created by erwinschens on 27.04.15.
 */
public class UserDao extends BaseDao<User> {
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    public User findById(Long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    public List<User> findAll() {
        return (List<User>) getCurrentSession().createCriteria(User.class).list();
    }

    public void deleteAll() {
        List<User> users = findAll();
        for (User u : users) {
            delete(u);
        }
    }
}
