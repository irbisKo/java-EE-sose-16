package com.alpha.dao;

import com.alpha.models.ParticipantListing;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by patrick on 10/10/15.
 */
public class ParticipantListingDao extends BaseDao<ParticipantListing> implements IParticipantListingDao{

    public ParticipantListing getByParticipantListAndParticipant(Long participantListId, Long participantId) {
        return (ParticipantListing) getCurrentSession().
                createCriteria(ParticipantListing.class).
                add(Restrictions.and(
                        Restrictions.eq(ParticipantListing.COLUMN_PARTICIPANT_LIST_ID, participantListId),
                        Restrictions.eq(ParticipantListing.COLUMN_PARTICIPANT_ID, participantId))).uniqueResult();
    }

    public void persist(ParticipantListing entity) {
        getCurrentSession().save(entity);
    }

    public void update(ParticipantListing entity) {
         getCurrentSession().update(entity);
    }

    public ParticipantListing findById(Long id) {
        return (ParticipantListing) getCurrentSession().get(ParticipantListing.class, id);
    }

    public void delete(ParticipantListing entity) {
        getCurrentSession().delete(entity);
    }

    public List<ParticipantListing> findAll() {
        return (List<ParticipantListing>) getCurrentSession().createCriteria(ParticipantListing.class).list();
    }

    public void deleteAll() {
        List<ParticipantListing> participantListings = findAll();
        for (ParticipantListing list : participantListings) {
            delete(list);
        }
    }
}
