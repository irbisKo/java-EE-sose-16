package com.alpha.service;

import com.alpha.models.Role;
import com.alpha.models.User;

import java.util.Set;

/**
 * Created by patrick on 10/10/15.
 */
public interface IUserService extends IBaseService<User> {

    User findByEmail(String email);
}
