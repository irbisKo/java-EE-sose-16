package com.alpha.common;

import com.alpha.models.Token;
import com.alpha.service.TokenService;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

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
