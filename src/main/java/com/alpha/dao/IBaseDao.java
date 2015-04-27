package com.alpha.dao;

import com.alpha.models.IModel;

import java.util.List;

/**
 * Created by erwinschens on 27.04.15.
 */
public interface IBaseDao<T extends IModel> {
    void persist(T entity);

    void update(T entity);

    T findById(Long id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
