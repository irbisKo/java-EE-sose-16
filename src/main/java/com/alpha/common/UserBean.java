package com.alpha.common;

import com.alpha.models.User;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by arturschens on 10.10.15.
 */
@ManagedBean
@SessionScoped
public class UserBean {

    public List<User> getUsers() {
        UserService us = new UserService();
        return us.findAll();
    }

}
