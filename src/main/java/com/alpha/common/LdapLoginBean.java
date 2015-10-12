package com.alpha.common;

import com.alpha.models.User;
import com.alpha.service.UserService;
import com.alpha.util.LdapAuthenticator;
import com.alpha.util.MessageSender;
import com.alpha.util.PasswordEncryption;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by erwinschens on 12.10.15.
 */
@ManagedBean
@SessionScoped
public class LdapLoginBean {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() throws NoSuchAlgorithmException {
        boolean valid = new LdapAuthenticator().authenticate(this.username, this.password);
        if (valid) {
            User user = new UserService().findByEmail(username + "@uni-koblenz.de");
            if (user == null) {
                user = initializeNewUser();
                new UserService().persist(user);
            }
            HttpSession session = SessionBean.getSession();
            session.setAttribute("email", this.username + "@uni-koblenz.de");
            session.setAttribute("userid", user.getId());
            return "hello";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(new MessageSender().getI18nMessage("login.fail.invalid_credentials.title"), new MessageSender().getI18nMessage("login.fail.invalid_credentials.text")));
            return "login";
        }
    }

    private User initializeNewUser() throws NoSuchAlgorithmException {
        User user = new User();
        user.setEmail(username + "@uni-koblenz.de");
        user.setSalt(new PasswordEncryption().generateSalt());
        user.setPasswordEncrypted(new PasswordEncryption().getEncryptedPassword(this.password, user.getSalt()));
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return user;
    }
}
