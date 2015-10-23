package com.alpha.dao;

import com.alpha.models.Poll;

import java.util.List;
import java.util.Set;

public interface IPollDao {

    List<Poll> findByUserId(Long userId, String... fetchFields);
}
