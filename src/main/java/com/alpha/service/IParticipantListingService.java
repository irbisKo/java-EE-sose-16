package com.alpha.service;

import com.alpha.models.ParticipantListing;

/**
 * Created by patrick on 10/10/15.
 */
public interface IParticipantListingService {

    ParticipantListing getByParticipantListAndParticipant(Long participantListId, Long participantId);

}
