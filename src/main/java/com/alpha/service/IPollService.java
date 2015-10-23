package com.alpha.service;

import com.alpha.models.Item;
import com.alpha.models.ParticipantList;
import com.alpha.models.Poll;
import com.alpha.models.User;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IPollService extends IBaseService<Poll> {
    void addItemToPoll(Poll poll, Item item);

    void removeItemFromPoll(Poll poll, Item item);

    void addParticipantListToPoll(Poll poll, ParticipantList participantList);

    void removeParticipantListToPoll(Poll poll, ParticipantList participantList);

    void addUserToPoll(Poll poll, User user);

    void removeUserFromPoll(Poll poll, User user);

    List<Poll> findByUser(User user, String... fetchFields);
}
