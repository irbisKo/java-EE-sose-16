package com.alpha.dao;

import com.alpha.models.Poll;

import java.util.Set;

public interface IPollDao {

    Set<Poll> findByUserId(Long userId);
}
