package com.alpha.common.user;

import com.alpha.common.role.RoleHolderBean;
import com.alpha.models.User;
import com.alpha.service.IRoleService;
import com.alpha.service.IUserService;
import com.alpha.service.RoleService;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserBean {

    @ManagedProperty(value = "#{roleHolderBean}")
    private RoleHolderBean roleHolderBean;
    private static IUserService userService;
    private static IRoleService roleService;
    private List<User> users;

    public UserBean() {
        userService = new UserService();
        roleService = new RoleService();
    }

    public void preRender() {
        this.users = userService.findAll(User.FIELD_ROLES);
    }

    public boolean isAdmin(User user) {
        return roleService.userHasRole(user, roleHolderBean.getAdmin());
    }

    public boolean isOrganizer(User user) {
        return roleService.userHasRole(user, roleHolderBean.getOrganizer());
    }


    // ==== Getter && Setter ====

    public RoleHolderBean getRoleHolderBean() {
        return roleHolderBean;
    }

    public void setRoleHolderBean(RoleHolderBean roleHolderBean) {
        this.roleHolderBean = roleHolderBean;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
