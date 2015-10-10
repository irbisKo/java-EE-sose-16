package com.alpha.dao;

import com.alpha.models.Participant;
import com.alpha.models.ParticipantList;

import java.util.List;

public interface IParticipantListDao {
    List<Participant> findParticipants(ParticipantList participantList);
}
