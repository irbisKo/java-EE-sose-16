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

    public Token findByToken(String tokenText) {
        tokenDao.openCurrentSession();
        Token token = tokenDao.findByToken(tokenText);
        tokenDao.closeCurrentSession();
        return token;
    }

    public Token newToken() {

        tokenDao.openCurrentSession();
        Token token = new Token();
        String tokenUid = "";
        do {
            tokenUid = UUID.randomUUID().toString();
        } while(tokenExists(tokenUid));

        tokenDao.getCurrentSession().beginTransaction();
        token.setToken(tokenUid);
        token.setCreatedAt(new Date());
        token.setUpdatedAt(new Date());
        tokenDao.persist(token);
        tokenDao.getCurrentSession().getTransaction().commit();
        tokenDao.closeCurrentSession();
        return token;
    }

    private boolean tokenExists(String tokenText) {
        boolean tokenFound = false;
        tokenDao.openCurrentSession();
        List<Token> tokens = tokenDao.findAll();
        for (Token token : tokens) {
            if (token.getToken().equals(tokenText)) {
                tokenFound = true;
                break;
            }
        }
        return tokenFound;
    }
}
