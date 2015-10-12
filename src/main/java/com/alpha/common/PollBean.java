package com.alpha.common;

import com.alpha.models.ParticipantList;
import com.alpha.models.Poll;
import com.alpha.models.User;
import com.alpha.service.IPollService;
import com.alpha.service.PollService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class PollBean implements Serializable {

    private static IPollService pollService;

    public PollBean() {
        pollService = new PollService();
    }

    public ArrayList<Poll> getCurrentUserPolls() {
        return (ArrayList<Poll>) pollService.findByUser(SessionBean.currentUser());
    }

    public void addUserToPoll(Poll poll, User user) {
        pollService.addUserToPoll(poll, user);
    }

    public void removeUserFromPoll(Poll poll, User user) {
        pollService.removeUserFromPoll(poll, user);
    }

    public void addParticipantListToPoll(Poll poll, ParticipantList participantList) {
        pollService.addParticipantListToPoll(poll, participantList);
    }

    public void removeParticipantListFromPoll(Poll poll, ParticipantList participantList) {
        pollService.removeParticipantListToPoll(poll, participantList);
    }



}
