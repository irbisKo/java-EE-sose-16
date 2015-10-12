package com.alpha.dao;

import com.alpha.models.IModel;

import java.util.List;


public interface IBaseDao<T extends IModel> {
    void persist(T entity);

    void update(T entity);

    T findById(Long id, String... fetchFields);

    void delete(T entity);

    List<T> findAll(String... fetchFields);

    void deleteAll();
}
