package com.alpha.dao;

import com.alpha.models.Role;
import com.alpha.models.User;
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

    public UserRole findByUserandRole(User user, Role role) {
        return (UserRole) getCurrentSession().createCriteria(UserRole.class).add(Restrictions.and(Restrictions.eq(UserRole.FIELD_USER, user), Restrictions.eq(UserRole.FIELD_ROLE, role))).uniqueResult();
    }
}
