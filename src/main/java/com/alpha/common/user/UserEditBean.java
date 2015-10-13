package com.alpha.common.user;


import com.alpha.common.role.RoleHolderBean;
import com.alpha.models.User;
import com.alpha.service.IRoleService;
import com.alpha.service.IUserService;
import com.alpha.service.RoleService;
import com.alpha.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserEditBean {


    @ManagedProperty(value = "#{roleHolderBean}")
    private RoleHolderBean roleHolderBean;
    private static IUserService userService;
    private static IRoleService roleService;
    private User user;
    private Long userId;

    public UserEditBean() {
        userService = new UserService();
        roleService = new RoleService();
    }

    public void preRender() {
        this.user = userService.findById(this.userId, User.FIELD_ROLES, User.FIELD_POLLS);
    }

    // ==== Getter && Setter ====

    public RoleHolderBean getRoleHolderBean() {
        return roleHolderBean;
    }

    public void setRoleHolderBean(RoleHolderBean roleHolderBean) {
        this.roleHolderBean = roleHolderBean;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
