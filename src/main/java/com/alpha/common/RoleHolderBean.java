package com.alpha.common;

import com.alpha.models.Role;
import com.alpha.service.IRoleService;
import com.alpha.service.RoleService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by patrick on 11/10/15.
 */
@ManagedBean
@ApplicationScoped
public class RoleHolderBean {

    private static IRoleService roleService;
    private Role admin;
    private Role organizer;

    public RoleHolderBean() {
        this.roleService = new RoleService();
        this.admin = roleService.findById(1L);
        this.organizer = roleService.findById(2L);
    }

    public Role getOrganizer() {
        return organizer;
    }

    public Role getAdmin() {
        return admin;
    }
}
