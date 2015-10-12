package com.alpha.dao;

import com.alpha.models.ParticipantListing;

public interface IParticipantListingDao {

    ParticipantListing getByParticipantListAndParticipant(Long participantListId, Long participantId);
}
