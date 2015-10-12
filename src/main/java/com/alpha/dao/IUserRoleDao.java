package com.alpha.dao;

import com.alpha.models.Role;
import com.alpha.models.User;
import com.alpha.models.UserRole;

/**
 * Created by patrick on 11/10/15.
 */
public interface IUserRoleDao {

    UserRole findByUserandRole(User user, Role role);
}
