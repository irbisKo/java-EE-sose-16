package com.alpha.common.user;

import com.alpha.models.User;
import com.alpha.service.IUserService;
import com.alpha.service.UserService;
import com.alpha.util.EmailSender;
import com.alpha.util.FlashMessage;
import com.alpha.util.PasswordEncryption;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@ManagedBean
@ViewScoped
public class NewUserBean {
    private static IUserService userService;
    private String email;
    private String password;
    private String passwordConfirmation;
    private EmailSender emailSender;

    public NewUserBean() {
        userService = new UserService();
        emailSender = new EmailSender();
    }

    public String createNewUser() throws NoSuchAlgorithmException, MessagingException {
        if (getEmail() == null || (!getPassword().equals(getPasswordConfirmation()))) {
            FlashMessage.showFlashError("user.create.error.title", "user.create.error.text");
            return "newUser";
        } else {
            if (userService.findByEmail(getEmail()) != null) {
                FlashMessage.showFlashError("user.create.error.title", "user.create.error.text");
                return "newUser";
            } else {
                User user = buildNewUser();
                userService.persist(user);
                sendConfirmationMail(user);
                FlashMessage.showFlashInfo("user.create.success.title", "user.create.success.text");
                return "hello";
            }
        }
    }

    private void sendConfirmationMail(User user) throws MessagingException {
        emailSender.sendPlainMail(user.getEmail(), "Sie wurden registriert", "Sie wurden bei votes registriert mit dem Benutzernamen: " + user.getEmail());
        user.setConfirmationSentAt(new Date());
        userService.update(user);
    }

    private User buildNewUser() throws NoSuchAlgorithmException {
        User user = new User();
        user.setEmail(getEmail());
        user.setSalt(new PasswordEncryption().generateSalt());
        user.setPasswordEncrypted(new PasswordEncryption().getEncryptedPassword(this.getPassword(), user.getSalt()));
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
