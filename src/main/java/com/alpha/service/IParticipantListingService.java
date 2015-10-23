package com.alpha.service;

import com.alpha.models.ParticipantListing;

public interface IParticipantListingService {

    ParticipantListing getByParticipantListAndParticipant(Long participantListId, Long participantId);

}
