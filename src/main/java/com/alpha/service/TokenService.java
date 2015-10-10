package com.alpha.service;

import com.alpha.dao.TokenDao;
import com.alpha.models.Token;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by arturschens on 10.10.15.
 */
public class TokenService {
    private static TokenDao tokenDao;

    public TokenService() {
        tokenDao = new TokenDao();
    }

    public void newToken() {
        tokenDao.openCurrentSession().beginTransaction();
        tokenDao.persist(tokenDao.newToken());
        tokenDao.getCurrentSession().getTransaction().commit();
        tokenDao.closeCurrentSession();
    }

}
