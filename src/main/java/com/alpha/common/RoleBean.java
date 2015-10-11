package com.alpha.common;

import com.alpha.models.Role;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by arturschens on 10.10.15.
 */
@ManagedBean
@SessionScoped
public class RoleBean {

    public List<Role> getRoles(Long userId) {
        UserService us = new UserService();
        return us.getRoles(userId);
    }
}
