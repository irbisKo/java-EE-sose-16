package com.alpha.common;

import com.alpha.models.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        examplePersistCall();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void examplePersistCall() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setEmail("test@web.de");
        user.setPasswordEncrypted("test1234");

        session.save(user);
        session.getTransaction().commit();
        System.out.println("Great! User was saved");
    }
}