package com.alpha.dao;

import com.alpha.models.Role;
import com.alpha.models.User;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Set;

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
