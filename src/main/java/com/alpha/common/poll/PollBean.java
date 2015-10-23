package com.alpha.common.poll;

import com.alpha.common.SessionBean;
import com.alpha.common.role.RoleHolderBean;
import com.alpha.models.ParticipantList;
import com.alpha.models.Poll;
import com.alpha.models.User;
import com.alpha.service.IPollService;
import com.alpha.service.IRoleService;
import com.alpha.service.PollService;
import com.alpha.service.RoleService;
import com.alpha.util.FlashMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class PollBean implements Serializable {

    @ManagedProperty(value = "#{roleHolderBean}")
    private RoleHolderBean roleHolderBean;
    private static IPollService pollService;
    private static IRoleService roleService;
    private List<Poll> pollList;

    public PollBean() {
        pollService = new PollService();
        roleService = new RoleService();
    }

    public void preRender() {
        User currentUser = SessionBean.currentUser();
        if (roleService.userHasRole(currentUser, roleHolderBean.getAdmin())) {
            pollList = pollService.findAll(Poll.FIELD_USERS);
        } else {
            pollList = pollService.findByUser(SessionBean.currentUser(), Poll.FIELD_USERS);
        }
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

    public RoleHolderBean getRoleHolderBean() {
        return roleHolderBean;
    }

    public void setRoleHolderBean(RoleHolderBean roleHolderBean) {
        this.roleHolderBean = roleHolderBean;
    }

    public List<Poll> getPollList() {
        return pollList;
    }

    public void setPollList(List<Poll> pollList) {
        this.pollList = pollList;
    }
}
