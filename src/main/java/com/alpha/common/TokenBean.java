package com.alpha.common;

import com.alpha.models.Participant;
import com.alpha.models.Role;
import com.alpha.service.ParticipantListService;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

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
        // TokenService tokenService = new TokenService();
        //  tokenService.newToken();


        UserService us = new UserService();
        List<Role> roles = us.getRoles(1L);

        for(Role r : roles) {
            System.out.println(r.getRoleName());
        }
    }

}
