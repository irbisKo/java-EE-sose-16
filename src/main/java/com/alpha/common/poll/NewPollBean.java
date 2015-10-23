package com.alpha.common.poll;

import com.alpha.models.Poll;
import com.alpha.service.IPollService;
import com.alpha.service.PollService;
import com.alpha.util.FlashMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class NewPollBean {
    private static IPollService pollService;
    public Poll poll;

    public NewPollBean() {
        pollService = new PollService();
        poll = new Poll();
    }

    public String createPoll(){
        pollService.persist(poll);
        return "polls?faces-redirect=true";
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
