package com.alpha.dao;


import com.alpha.models.Poll;
import com.alpha.models.Poll;
import com.alpha.models.User;
import com.alpha.models.UserPollListing;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;
import java.util.Set;

public class PollDao extends BaseDao<Poll> implements IPollDao {

    public void persist(Poll entity) {
        getCurrentSession().save(entity);
    }

    public void update(Poll entity) {
        getCurrentSession().update(entity);
    }

    public Poll findById(Long id, String... fetchFields) {
        return (Poll) getRootCriteria(Poll.class, fetchFields)
                .add(Restrictions.eq(Poll.COLUMN_ID, id))
                .uniqueResult();
    }

    public void delete(Poll entity) {
        getCurrentSession().delete(entity);
    }

    public List<Poll> findAll(String... fetchFields) {
        return (List<Poll>) getRootCriteria(Poll.class, fetchFields)
                .list();
    }

    public void deleteAll() {
        List<Poll> polls = findAll();
        for (Poll u : polls) {
            delete(u);
        }
    }

    public List<Poll> findByUserId(Long userId, String... fetchFields) {
        Criteria criteria = getRootCriteria(Poll.class, fetchFields)
                .createAlias(User.TABLE_NAME, "user")
                .add(Restrictions.eq("user." + User.COLUMN_ID, userId));

        return (List<Poll>) criteria.list();
    }
}
