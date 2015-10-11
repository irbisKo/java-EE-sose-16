package com.alpha.dao;

import com.alpha.models.UserRole;

/**
 * Created by patrick on 11/10/15.
 */
public interface IUserRoleDao {

    UserRole findByUserIdandRoleId(Long userId, Long roleId);
}
