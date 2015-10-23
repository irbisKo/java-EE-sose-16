package com.alpha.service;

import com.alpha.models.Role;
import com.alpha.models.User;

public interface IRoleService extends IBaseService<Role> {

    boolean userHasRole(User user,Role role);
}
