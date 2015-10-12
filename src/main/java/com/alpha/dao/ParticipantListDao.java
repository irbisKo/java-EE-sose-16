package com.alpha.dao;

import com.alpha.models.Participant;
import com.alpha.models.ParticipantList;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class ParticipantListDao extends BaseDao<ParticipantList> implements IParticipantListDao {

    public void persist(ParticipantList entity) {
        getCurrentSession().save(entity);
    }

    public void update(ParticipantList entity) {
        getCurrentSession().update(entity);
    }

    public ParticipantList findById(Long id, String... fetchFields) {
        return (ParticipantList) getRootCriteria(ParticipantList.class, fetchFields)
                .add(Restrictions.eq(ParticipantList.COLUMN_ID, id));
    }

    public void delete(ParticipantList entity) {
        getCurrentSession().delete(entity);
    }

    public List<ParticipantList> findAll(String... fetchFields) {
        return (List<ParticipantList>) getRootCriteria(ParticipantList.class, fetchFields)
                .list();
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
