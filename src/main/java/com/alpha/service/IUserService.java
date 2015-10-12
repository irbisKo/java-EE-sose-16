package com.alpha.service;

import com.alpha.models.User;

public interface IUserService extends IBaseService<User> {

    User findByEmail(String email);
}
