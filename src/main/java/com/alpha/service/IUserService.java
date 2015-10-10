package com.alpha.service;

import com.alpha.models.User;

/**
 * Created by patrick on 10/10/15.
 */
public interface IUserService {

    User findByEmail(String email);
}
