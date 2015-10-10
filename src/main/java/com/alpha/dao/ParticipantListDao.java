package com.alpha.dao;

import com.alpha.models.Participant;
import com.alpha.models.ParticipantList;

import java.util.ArrayList;
import java.util.List;

public class ParticipantListDao extends BaseDao<ParticipantList> implements IParticipantListDao {

    public void persist(ParticipantList entity) {
        getCurrentSession().save(entity);
    }

    public void update(ParticipantList entity) {
        getCurrentSession().update(entity);
    }

    public ParticipantList findById(Long id) {
        return (ParticipantList) getCurrentSession().get(ParticipantList.class, id);
    }

    public void delete(ParticipantList entity) {
        getCurrentSession().delete(entity);
    }

    public List<ParticipantList> findAll() {
        return (List<ParticipantList>) getCurrentSession().createCriteria(ParticipantList.class).list();
    }

    public void deleteAll() {
        List<ParticipantList> particpantLists = findAll();
        for (ParticipantList p : particpantLists) {
            delete(p);
        }
    }

    public List<Participant> findParticipants(ParticipantList participantList) {
        List<Participant> participants = new ArrayList<Participant>();
        participants.addAll(participantList.getParticipants());
        return participants;
    }
}
