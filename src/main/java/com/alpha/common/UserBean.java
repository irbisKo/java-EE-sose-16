package com.alpha.common;

import com.alpha.models.Role;
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

    private Long userId;

    public List<User> getUsers() {
        UserService us = new UserService();
        return us.findAll();
    }

    public boolean hasRole(Long userId, String roleName) {
        boolean roleFound = false;
        UserService us = new UserService();
        List<Role> roles = us.getRoles(userId);
        for (Role r : roles) {
            if (r.getRoleName().equals(roleName)) {
                roleFound = true;
                break;
            }
        }
        return roleFound;
    }

}
