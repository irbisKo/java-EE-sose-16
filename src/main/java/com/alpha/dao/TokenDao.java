package com.alpha.dao;

import com.alpha.models.Token;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

public class TokenDao extends BaseDao<Token> implements ITokenDao {

    public void persist(Token entity) {
        getCurrentSession().save(entity);
    }

    public void update(Token entity) {
        getCurrentSession().update(entity);
    }

    public Token findById(Long id, String... fetchFields) {
        return (Token) getRootCriteria(Token.class, fetchFields)
                .add(Restrictions.eq(Token.COLUMN_ID, id))
                .uniqueResult();
    }

    public void delete(Token entity) {
        getCurrentSession().delete(entity);
    }

    public List<Token> findAll(String... fetchFields) {
        return (List<Token>) getRootCriteria(Token.class,fetchFields)
                .list();
    }

    public void deleteAll() {
        List<Token> tokens = findAll();
        for (Token u : tokens) {
            delete(u);
        }
    }

    public Token findByToken(String token, String... fetchFields) {
        return (Token) getRootCriteria(Token.class, fetchFields)
                .add(Restrictions.eq(Token.COLUMN_TOKEN, token))
                .uniqueResult();
    }

    public Token newToken() {
        Token token = new Token();
        String tokenUid = "";
        do {
            tokenUid = new BigInteger(130, new SecureRandom()).toString(32).toUpperCase().substring(0, 10);
        } while(tokenExists(tokenUid));
        token.setToken(tokenUid);
        token.setCreatedAt(new Date());
        token.setUpdatedAt(new Date());
        return token;
    }

    private boolean tokenExists(String tokenText) {
        boolean tokenFound = false;
        if (findByToken(tokenText) != null) {
            tokenFound = true;
        }
        return tokenFound;
    }
}
