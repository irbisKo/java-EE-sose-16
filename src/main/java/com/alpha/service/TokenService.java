package com.alpha.service;

import com.alpha.dao.TokenDao;
import com.alpha.models.Token;

import java.util.List;

public class TokenService implements ITokenService {
    private static TokenDao tokenDao;

    public TokenService() {
        tokenDao = new TokenDao();
    }

    public Token findById(Long id, String... fetchFields) {
        tokenDao.openCurrentSession();
        Token token = tokenDao.findById(id);
        tokenDao.closeCurrentSession();
        return token;
    }

    public void newToken() {
        tokenDao.openCurrentSession().beginTransaction();
        this.persist(tokenDao.newToken());
        tokenDao.openCurrentSession().getTransaction().commit();
        tokenDao.closeCurrentSession();
    }

    public void persist(Token token) {
        tokenDao.openCurrentSessionwithTransaction();
        tokenDao.persist(token);
        tokenDao.closeCurrentSessionwithTransaction();
    }

    public void update(Token token) {
        tokenDao.openCurrentSessionwithTransaction();
        tokenDao.update(token);
        tokenDao.closeCurrentSessionwithTransaction();
    }


    public void delete(Long id) {
        tokenDao.openCurrentSessionwithTransaction();
        Token token = tokenDao.findById(id);
        tokenDao.delete(token);
        tokenDao.closeCurrentSessionwithTransaction();
    }

    public List<Token> findAll(String... fetchFields) {
        tokenDao.openCurrentSession();
        List<Token> token = tokenDao.findAll();
        tokenDao.closeCurrentSession();
        return token;
    }

    public void deleteAll() {
        tokenDao.openCurrentSessionwithTransaction();
        tokenDao.deleteAll();
        tokenDao.closeCurrentSessionwithTransaction();
    }
}
