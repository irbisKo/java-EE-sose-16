package com.alpha.common;

import com.alpha.models.User;
import com.alpha.service.IUserService;
import com.alpha.service.UserService;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBean {
    public SessionBean() {
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static String getUserEmail() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return session.getAttribute("email").toString();
    }

    public static Long getUserId() {
        HttpSession session = getSession();
        if (session != null)
            return (Long) session.getAttribute("userid");
        else
            return null;
    }

    public static User currentUser() {
        return new UserService().findById(getUserId());
    }
}
