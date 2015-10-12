package com.alpha.dao;


import com.alpha.models.Poll;
import com.alpha.models.Poll;
import com.alpha.models.User;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;
import java.util.Set;

public class PollDao extends BaseDao<Poll>  implements IPollDao {

    public void persist(Poll entity) {
        getCurrentSession().save(entity);
    }

    public void update(Poll entity) {
        getCurrentSession().update(entity);
    }

    public Poll findById(Long id) {
        return (Poll) getCurrentSession().get(Poll.class, id);
    }

    public void delete(Poll entity) {
        getCurrentSession().delete(entity);
    }

    public List<Poll> findAll() {
        return (List<Poll>) getCurrentSession().createCriteria(Poll.class).list();
    }

    public void deleteAll() {
        List<Poll> polls = findAll();
        for (Poll u : polls) {
            delete(u);
        }
    }

    public Set<Poll> findByUserId(Long userId) {
        return (Set<Poll>) getCurrentSession().createCriteria(Poll.class).createCriteria("users", JoinType.INNER_JOIN).add(Restrictions.eq(User.COLUMN_ID,userId));
    }
}
