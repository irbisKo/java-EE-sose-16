package com.alpha.dao;

import com.alpha.models.Role;
import com.alpha.models.User;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
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

    public User findByEmail(String email) {
        return (User) getCurrentSession().createCriteria(User.class).add(Restrictions.eq(User.COLUMN_EMAIL, email)).uniqueResult();
    }

    public List<Role> findRoles(User user) {
        List<Role> roles = new ArrayList<Role>();
        roles.addAll(user.getRoles());
        return roles;
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
