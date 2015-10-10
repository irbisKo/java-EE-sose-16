package com.alpha.service;

import com.alpha.models.Item;
import com.alpha.models.ParticipantList;
import com.alpha.models.Poll;
import com.alpha.models.User;

/**
 * Created by patrick on 10/10/15.
 */
public interface IPollService {
    void addItemToPoll(Poll poll, Item item);

    void removeItemFromPoll(Poll poll, Item item);

    void addParticipantListsToPoll(Poll poll, ParticipantList participantList);

    void removeParticipantListsToPoll(Poll poll, ParticipantList participantList);

    void addUserToPoll(Poll poll, User user);

    void removeUserFromPoll(Poll poll, User user);
}
