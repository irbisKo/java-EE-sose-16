package com.alpha.dao.login;

import com.alpha.service.UserService;

/**
 * Created by erwinschens on 10.10.15.
 */
public class LoginDao {

    public static boolean validate(String email, String password) {
        UserService userService = new UserService();
        return !(userService.findByEmailAndPassword(email, password) == null);
    }
}
