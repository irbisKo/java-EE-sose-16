package com.alpha.dao;

import com.alpha.models.Token;

public interface ITokenDao {

    Token findByToken(String token, String... fetchFields);

    Token newToken();

}
