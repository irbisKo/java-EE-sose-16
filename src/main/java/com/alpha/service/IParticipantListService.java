package com.alpha.service;

import com.alpha.models.Participant;
import com.alpha.models.ParticipantList;

public interface IParticipantListService {

    void addParticipant(ParticipantList participantList, Participant participant);

    void removeParticipant(ParticipantList participantList, Participant participant);

    public boolean isParticipantInList(ParticipantList participantList, Participant participant);

}
