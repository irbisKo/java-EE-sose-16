package com.alpha.dao;

import com.alpha.models.Participant;
import com.alpha.models.User;

import java.util.List;

public class ParticipantDao extends BaseDao<Participant> implements IParticipantDao  {
    public void persist(Participant entity) {
        getCurrentSession().save(entity);
    }

    public void update(Participant entity) {
        getCurrentSession().update(entity);
    }

    public Participant findById(Long id) {
        return (Participant) getCurrentSession().get(Participant.class, id);
    }

    public void delete(Participant entity) {
        getCurrentSession().delete(entity);
    }

    public List<Participant> findAll() {
        return (List<Participant>) getCurrentSession().createCriteria(Participant.class).list();
    }

    public void deleteAll() {
        List<Participant> participants = findAll();
        for (Participant p : participants) {
            delete(p);
        }
    }
}
