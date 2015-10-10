package com.alpha.common;

import com.alpha.service.TokenService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by arturschens on 10.10.15.
 */
@ManagedBean
@SessionScoped
public class TokenBean {

    public String getToken() {
        return "test";
    }

    public void newToken() {
        TokenService tokenService = new TokenService();
        tokenService.newToken();
    }

}
