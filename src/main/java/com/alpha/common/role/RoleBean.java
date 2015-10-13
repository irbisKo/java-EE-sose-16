package com.alpha.common.role;

import com.alpha.service.IUserService;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RoleBean {

    private RoleHolderBean roleHolderBean;
    private static IUserService userService;

    public RoleBean() {
        userService = new UserService();
    }
}
