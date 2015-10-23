package com.alpha.dao;

import com.alpha.models.Role;
import com.alpha.models.User;
import com.alpha.models.UserRole;

public interface IUserRoleDao {

    UserRole findByUserandRole(User user, Role role, String... fetchFields);
}
