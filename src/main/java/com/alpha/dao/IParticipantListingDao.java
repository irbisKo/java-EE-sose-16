package com.alpha.dao;

import com.alpha.models.Participant;
import com.alpha.models.ParticipantList;
import com.alpha.models.ParticipantListing;

/**
 * Created by patrick on 10/10/15.
 */
public interface IParticipantListingDao {

    ParticipantListing getByParticipantListAndParticipant(Long participantListId, Long participantId);
}
