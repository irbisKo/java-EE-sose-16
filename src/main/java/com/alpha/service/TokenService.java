package com.alpha.service;

import com.alpha.dao.TokenDao;
import com.alpha.models.Token;

/**
 * Created by arturschens on 10.10.15.
 */
public class TokenService {
    private static TokenDao tokenDao;

    public TokenService() {
        tokenDao = new TokenDao();
    }

    public Token findById(Long id) {
        tokenDao.openCurrentSession();
        Token token = tokenDao.findById(id);
        tokenDao.closeCurrentSession();
        return token;
    }

    public void newToken() {
        tokenDao.openCurrentSession().beginTransaction();
        tokenDao.persist(tokenDao.newToken());
        tokenDao.getCurrentSession().getTransaction().commit();
        tokenDao.closeCurrentSession();
    }

}
