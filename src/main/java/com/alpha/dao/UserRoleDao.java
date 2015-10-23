package com.alpha.dao;

import com.alpha.models.Role;
import com.alpha.models.User;
import com.alpha.models.UserRole;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class UserRoleDao extends BaseDao<UserRole> implements IUserRoleDao {

    public void persist(UserRole entity) {
        getCurrentSession().save(entity);
    }

    public void update(UserRole entity) {
        getCurrentSession().update(entity);
    }

    public UserRole findById(Long id,String... fetchFields) {
        return (UserRole) getRootCriteria(UserRole.class, fetchFields)
                .add(Restrictions.eq(UserRole.COLUMN_ID, id))
                .uniqueResult();
    }

    public void delete(UserRole entity) {
        getCurrentSession().delete(entity);
    }

    public List<UserRole> findAll(String... fetchFields) {
        return (List<UserRole>) getRootCriteria(UserRole.class, fetchFields)

                .list();
    }

    public void deleteAll() {
        List<UserRole> roles = findAll();
        for (UserRole r : roles) {
            delete(r);
        }
    }

    public UserRole findByUserandRole(User user, Role role, String... fetchFields) {
        return (UserRole) getRootCriteria(UserRole.class,fetchFields)
                .add(Restrictions.and(Restrictions.eq(UserRole.FIELD_USER, user), Restrictions.eq(UserRole.FIELD_ROLE, role)))
                .uniqueResult();
    }
}
