package com.alpha.common;

import com.alpha.models.Poll;
import com.alpha.service.IPollService;
import com.alpha.service.IUserService;
import com.alpha.service.PollService;
import com.alpha.service.UserService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class PollBean implements Serializable {

    private static IUserService userService;
    private static IPollService pollService;

    public PollBean() {
        userService = new UserService();
        pollService = new PollService();
    }

    public ArrayList<Poll> getCurrentUserPolls(){
        return new ArrayList<Poll>(pollService.findByUser(SessionBean.currentUser()));
    }

}
