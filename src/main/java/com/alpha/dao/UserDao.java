package com.alpha.dao;

import com.alpha.models.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDao extends BaseDao<User> implements IUserDao {
    public void persist(User entity) {
        getCurrentSession().save(entity);
    }

    public void update(User entity) {
        getCurrentSession().update(entity);
    }

    public User findById(Long id, String... fetchFields) {
        Criteria criteria = getRootCriteria(User.class);
        criteria.add(Restrictions.eq(User.COLUMN_ID, id));
        return (User) criteria.uniqueResult();
    }

    public User findByEmail(String email, String... fetchFields) {
        return (User) getRootCriteria(User.class, fetchFields)
                .add(Restrictions.eq(User.COLUMN_EMAIL, email))
                .uniqueResult();
    }

    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    public List<User> findAll(String... fetchFields) {
        return (List<User>) getRootCriteria(User.class, fetchFields)
                .list();
    }

    public void deleteAll() {
        List<User> users = findAll();
        for (User u : users) {
            delete(u);
        }
    }
}
