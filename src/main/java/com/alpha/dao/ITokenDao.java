package com.alpha.dao;

import com.alpha.models.Token;

/**
 * Created by arturschens on 10.10.15.
 */
public interface ITokenDao{

    public Token findByToken(String token);

}
