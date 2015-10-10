package com.alpha.service;

import com.alpha.dao.ParticipantDao;
import com.alpha.dao.ParticipantListDao;
import com.alpha.dao.ParticipantListingDao;
import com.alpha.models.Participant;
import com.alpha.models.ParticipantList;
import com.alpha.models.ParticipantListing;

import java.util.List;

public class ParticipantListService implements IBaseService<ParticipantList>,IParticipantListService {

    private static ParticipantListDao participantListDao;
    private static ParticipantDao participantDao;
    private static ParticipantListingDao participantListingDao;
    private static ParticipantListingService participantListingService;

    public ParticipantListService() {
        participantListDao = new ParticipantListDao();
        participantListingDao = new ParticipantListingDao();
        participantDao = new ParticipantDao();
        participantListingService = new ParticipantListingService();
    }

    public void addParticipant(ParticipantList participantList, Participant participant) {
        ParticipantListing participantListing = participantListingDao.getByParticipantListAndParticipant(participantList.getId(), participant.getId());
        if (participantListing == null) {
            participantListing = new ParticipantListing(participant, participantList);
            participantListingService.persist(participantListing);
        }
    }

    public void removeParticipant(ParticipantList participantList, Participant participant) {
        ParticipantListing participantListing = participantListingDao.getByParticipantListAndParticipant(participantList.getId(), participant.getId());
        if (participantListing != null) {
            participantListingService.delete(participantListing.getId());
        }
    }

    public boolean isParticipantInList(ParticipantList participantList, Participant participant) {
        return !(participantListingService.getByParticipantListAndParticipant(participantList.getId(), participant.getId()) == null);
    }

    public void persist(ParticipantList participantList) {
        participantListDao.openCurrentSessionwithTransaction();
        participantListDao.persist(participantList);
        participantListDao.closeCurrentSessionwithTransaction();
    }

    public void update(ParticipantList participantList) {
        participantListDao.openCurrentSessionwithTransaction();
        participantListDao.update(participantList);
        participantListDao.closeCurrentSessionwithTransaction();
    }

    public ParticipantList findById(Long id) {
        participantListDao.openCurrentSession();
        ParticipantList participantList = participantListDao.findById(id);
        participantListDao.closeCurrentSession();
        return participantList;
    }

    public void delete(Long id) {
        participantListDao.openCurrentSessionwithTransaction();
        ParticipantList participantList = participantListDao.findById(id);
        participantListDao.delete(participantList);
        participantListDao.closeCurrentSessionwithTransaction();
    }

    public List<ParticipantList> findAll() {
        participantListDao.openCurrentSession();
        List<ParticipantList> participantList = participantListDao.findAll();
        participantListDao.closeCurrentSession();
        return participantList;
    }

    public void deleteAll() {
        participantListDao.openCurrentSessionwithTransaction();
        participantListDao.deleteAll();
        participantListDao.closeCurrentSessionwithTransaction();
    }
}
