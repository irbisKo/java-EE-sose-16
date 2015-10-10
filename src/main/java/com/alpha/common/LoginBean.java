package com.alpha.common;

import com.alpha.dao.login.LoginDao;
import com.alpha.models.User;
import com.alpha.service.UserService;
import com.alpha.util.Application;
import com.alpha.util.EmailSender;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by erwinschens on 10.10.15.
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String password;
    private String message;
    private String email;
    private User currentUser;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMessage() {
        return message;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String validateEmailPassword() {
        boolean valid = LoginDao.validate(email, password);
        if (valid) {
            this.currentUser = new UserService().findByEmailAndPassword(email, password);
            HttpSession session = SessionBean.getSession();
            session.setAttribute("email", email);
            return "hello";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("VALIDATION", "Ungültige Email oder Passwort"));
            return "login";
        }
    }

    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        this.currentUser = null;
        return "login";
    }
}
