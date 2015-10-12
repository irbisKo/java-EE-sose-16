package com.alpha.dao;

import com.alpha.models.User;

public interface IUserDao {

    User findByEmail(String email, String... fetchFields);
}
