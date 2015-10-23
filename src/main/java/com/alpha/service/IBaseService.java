package com.alpha.service;

import java.util.List;

public interface IBaseService<T> {

    void persist(T t);

    void update(T t);

    T findById(Long id, String... fetchFields);

    void delete(Long id);

    List<T> findAll(String... fetchFields);

    void deleteAll();

}
