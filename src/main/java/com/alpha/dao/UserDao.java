package com.alpha.dao;

import com.alpha.models.User;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by erwinschens on 27.04.15.
 */
public class UserDao extends BaseDao<User> implements IUserDao {
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    public User findById(Long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    public User findByEmailAndPassword(String email, String password) {
        return (User) getCurrentSession().createCriteria(User.class).add(Restrictions.and(Restrictions.eq(User.COLUMN_EMAIL, email), Restrictions.eq(User.COLUMN_PASSWORD_ENCRYPTED, password))).uniqueResult();
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
