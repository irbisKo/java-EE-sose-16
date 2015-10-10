package com.alpha.dao;

import com.alpha.models.IModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by erwinschens on 27.04.15.
 */
public abstract class BaseDao<T extends IModel> implements IBaseDao<T> {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    /**
     * Check long value that it can be identifier.
     *
     * @param id Long value for check
     * @throws IllegalArgumentException If id not valid
     * @noinspection NonBooleanMethodNameMayNotStartWithQuestion
     */
    protected static void checkId(final Long id) throws IllegalArgumentException {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("Call of the DAO method with illegal entity identifier: " + id);
        }
    }
}
