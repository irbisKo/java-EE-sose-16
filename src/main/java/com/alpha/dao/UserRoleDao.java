package com.alpha.dao;

import com.alpha.models.UserRole;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by patrick on 11/10/15.
 */
public class UserRoleDao extends BaseDao<UserRole> implements IUserRoleDao {

    public void persist(UserRole entity) {
        getCurrentSession().save(entity);
    }

    public void update(UserRole entity) {
        getCurrentSession().update(entity);
    }

    public UserRole findById(Long id) {
        return (UserRole) getCurrentSession().get(UserRole.class, id);
    }

    public void delete(UserRole entity) {
        getCurrentSession().delete(entity);
    }

    public List<UserRole> findAll() {
        return (List<UserRole>) getCurrentSession().createCriteria(UserRole.class).list();
    }

    public void deleteAll() {
        List<UserRole> roles = findAll();
        for (UserRole r : roles) {
            delete(r);
        }
    }

    public UserRole findByUserIdandRoleId(Long userId, Long roleId) {
        return (UserRole) getCurrentSession().createCriteria(UserRole.class).add(Restrictions.and(Restrictions.eq(UserRole.COLUMN_USER_ID, userId), Restrictions.eq(UserRole.COLUMN_ROLE_ID, roleId))).uniqueResult();
    }
}
