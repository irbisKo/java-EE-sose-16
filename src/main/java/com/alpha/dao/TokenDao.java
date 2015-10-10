package com.alpha.dao;

import com.alpha.models.Token;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by arturschens on 10.10.15.
 */
public class TokenDao extends BaseDao<Token> implements ITokenDao {

    private Token token;

    public TokenDao() {
        token = new Token();
    }

    public TokenDao(Long id) {
        token = findById(id);
    }

    public TokenDao(String tokenText) {
        token = findByToken(tokenText);
    }

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

    public void generateToken() {
        token.setToken("abcdef");
    }
}
