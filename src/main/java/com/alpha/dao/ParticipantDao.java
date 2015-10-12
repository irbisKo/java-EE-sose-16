package com.alpha.dao;

import com.alpha.models.Participant;
import com.alpha.models.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ParticipantDao extends BaseDao<Participant> implements IParticipantDao  {
    public void persist(Participant entity) {
        getCurrentSession().save(entity);
    }

    public void update(Participant entity) {
        getCurrentSession().update(entity);
    }

    public Participant findById(Long id, String... fetchFields) {
        return (Participant) getRootCriteria(Participant.class, fetchFields)
                .add(Restrictions.eq(Participant.COLUMN_ID, id))
                .uniqueResult();
    }

    public void delete(Participant entity) {
        getCurrentSession().delete(entity);
    }

    public List<Participant> findAll(String... fetchFields) {

        return (List<Participant>) getRootCriteria(Participant.class, fetchFields)
                .list();
    }

    public void deleteAll() {
        List<Participant> participants = findAll();
        for (Participant p : participants) {
            delete(p);
        }
    }
}
