package com.alpha.dao;

import com.alpha.models.Token;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by arturschens on 10.10.15.
 */
public class TokenDao extends BaseDao<Token> implements ITokenDao {

    public void persist(Token entity) {
        getCurrentSession().save(entity);
    }

    public void update(Token entity) {
        getCurrentSession().update(entity);
    }

    public Token findById(Long id) {
        return (Token) getCurrentSession().get(Token.class, id);
    }

    public void delete(Token entity) {
        getCurrentSession().delete(entity);
    }

    public List<Token> findAll() {
        return (List<Token>) getCurrentSession().createCriteria(Token.class).list();
    }

    public void deleteAll() {
        List<Token> tokens = findAll();
        for (Token u : tokens) {
            delete(u);
        }
    }

    public Token findByToken(String token) {
        return (Token) getCurrentSession().createCriteria(Token.class).add(Restrictions.eq("token", token)).uniqueResult();
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
        List<Token> tokens = findAll();
        for (Token token : tokens) {
            if (token.getToken().equals(tokenText)) {
                tokenFound = true;
                break;
            }
        }
        return tokenFound;
    }
}
