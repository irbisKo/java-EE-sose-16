package com.alpha.service;

import com.alpha.models.Role;
import com.alpha.models.User;

/**
 * Created by patrick on 11/10/15.
 */
public interface IRoleService extends IBaseService<Role> {

    boolean userHasRole(User user,Role role);
}
