package com.alpha.common;

import com.alpha.models.Participant;
import com.alpha.models.ParticipantList;
import com.alpha.models.Role;
import com.alpha.service.ParticipantListService;
import com.alpha.service.TokenService;
import com.alpha.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Set;

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

        ParticipantListService pls = new ParticipantListService();
        ParticipantList plls = pls.findById(1L);
        for (Participant p : plls.getParticipants()) {
            System.out.println(p.getEmail());
        }
    }

}
