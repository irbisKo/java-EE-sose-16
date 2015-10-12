package com.alpha.service;

import com.alpha.dao.ParticipantListingDao;
import com.alpha.models.ParticipantListing;

import java.util.List;

public class ParticipantListingService implements IBaseService<ParticipantListing>, IParticipantListingService {

    private static ParticipantListingDao participantListingDao;

    public ParticipantListingService() {
        participantListingDao = new ParticipantListingDao();
    }
    
    public void persist(ParticipantListing participantListing) {
        participantListingDao.openCurrentSessionwithTransaction();
        participantListingDao.persist(participantListing);
        participantListingDao.closeCurrentSessionwithTransaction();
    }

    public void update(ParticipantListing participantListing) {
        participantListingDao.openCurrentSessionwithTransaction();
        participantListingDao.update(participantListing);
        participantListingDao.closeCurrentSessionwithTransaction();
    }

    public ParticipantListing findById(Long id, String... fetchFields) {
        participantListingDao.openCurrentSession();
        ParticipantListing participantListing = participantListingDao.findById(id);
        participantListingDao.closeCurrentSession();
        return participantListing;
    }

    public void delete(Long id) {
        participantListingDao.openCurrentSessionwithTransaction();
        ParticipantListing book = participantListingDao.findById(id);
        participantListingDao.delete(book);
        participantListingDao.closeCurrentSessionwithTransaction();
    }

    public List<ParticipantListing> findAll(String... fetchFields) {
        participantListingDao.openCurrentSession();
        List<ParticipantListing> participantListings = participantListingDao.findAll();
        participantListingDao.closeCurrentSession();
        return participantListings;
    }

    public void deleteAll() {
        participantListingDao.openCurrentSessionwithTransaction();
        participantListingDao.deleteAll();
        participantListingDao.closeCurrentSessionwithTransaction();
    }

    public ParticipantListing getByParticipantListAndParticipant(Long participantListId, Long participantId) {
        participantListingDao.openCurrentSessionwithTransaction();
        ParticipantListing participantListing = participantListingDao.getByParticipantListAndParticipant(participantListId, participantId);
        participantListingDao.closeCurrentSessionwithTransaction();
        return participantListing;
    }
}
