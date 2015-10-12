package com.alpha.common;

import com.alpha.service.IUserService;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class RoleBean {

    @Inject
    private RoleHolderBean roleHolderBean;
    private static IUserService userService;

    public RoleBean() {
        userService = new UserService();
    }
}
