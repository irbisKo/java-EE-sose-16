package com.alpha.service;

import com.alpha.dao.UserDao;
import com.alpha.models.Role;
import com.alpha.models.User;

import java.util.List;

/**
 * Created by erwinschens on 27.04.15.
 */
public class UserService implements IBaseService<User>,IUserService {

    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void persist(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.persist(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public void update(User user) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public User findById(Long id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public User findByEmail(String email) {
        userDao.openCurrentSession();
        User user = userDao.findByEmail(email);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(Long id) {
        userDao.openCurrentSessionwithTransaction();
        User book = userDao.findById(id);
        userDao.delete(book);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<Role> getRoles(Long userId) {
        userDao.openCurrentSession();
        User user = userDao.findById(userId);
        List<Role> roles = userDao.findRoles(user);
        userDao.closeCurrentSession();
        return roles;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
