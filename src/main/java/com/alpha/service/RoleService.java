package com.alpha.service;

import com.alpha.dao.RoleDao;
import com.alpha.dao.UserRoleDao;
import com.alpha.models.Role;
import com.alpha.models.Role;
import com.alpha.models.User;
import com.alpha.models.UserRole;

import java.util.List;

/**
 * Created by patrick on 11/10/15.
 */
public class RoleService implements IRoleService {

    private static RoleDao roleDao;
    private static UserRoleDao userRoleDao;


    public RoleService() {
        this.roleDao = new RoleDao();
        this.userRoleDao = new UserRoleDao();
    }

    public void persist(Role participantList) {
        roleDao.openCurrentSessionwithTransaction();
        roleDao.persist(participantList);
        roleDao.closeCurrentSessionwithTransaction();
    }

    public void update(Role participantList) {
        roleDao.openCurrentSessionwithTransaction();
        roleDao.update(participantList);
        roleDao.closeCurrentSessionwithTransaction();
    }

    public Role findById(Long id) {
        roleDao.openCurrentSession();
        Role participantList = roleDao.findById(id);
        roleDao.closeCurrentSession();
        return participantList;
    }

    public void delete(Long id) {
        roleDao.openCurrentSessionwithTransaction();
        Role participantList = roleDao.findById(id);
        roleDao.delete(participantList);
        roleDao.closeCurrentSessionwithTransaction();
    }

    public List<Role> findAll() {
        roleDao.openCurrentSession();
        List<Role> participantList = roleDao.findAll();
        roleDao.closeCurrentSession();
        return participantList;
    }

    public void deleteAll() {
        roleDao.openCurrentSessionwithTransaction();
        roleDao.deleteAll();
        roleDao.closeCurrentSessionwithTransaction();
    }

    public boolean userHasRole(User user, Role role) {
        userRoleDao.openCurrentSessionwithTransaction();
        UserRole userRole = userRoleDao.findByUserandRole(user, role);
        userRoleDao.closeCurrentSessionwithTransaction();
        return !(userRole == null);
    }
}
