package com.alpha.dao;

import com.alpha.models.Role;

import java.util.List;

/**
 * Created by patrick on 11/10/15.
 */
public class RoleDao extends BaseDao<Role> implements IRoleDao {

    public void persist(Role entity) {
        getCurrentSession().save(entity);
    }

    public void update(Role entity) {
        getCurrentSession().update(entity);
    }

    public Role findById(Long id) {
        return (Role) getCurrentSession().get(Role.class, id);
    }

    public void delete(Role entity) {
        getCurrentSession().delete(entity);
    }

    public List<Role> findAll() {
        return (List<Role>) getCurrentSession().createCriteria(Role.class).list();
    }

    public void deleteAll() {
        List<Role> roles = findAll();
        for (Role r : roles) {
            delete(r);
        }
    }
    
}
