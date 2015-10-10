package com.alpha.dao.login;

import com.alpha.models.User;
import com.alpha.service.UserService;
import com.alpha.util.PasswordEncryption;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by erwinschens on 10.10.15.
 */
public class LoginDao {

    public static boolean validate(String email, String password) {
        UserService userService = new UserService();
        User user = userService.findByEmail(email);
        if (user == null) {
            return false;
        } else {
            return new PasswordEncryption().authenticate(password, user.getPasswordEncrypted(), user.getSalt());
        }
    }
}
