package com.alpha.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ResourceBundle;

/**
 * Created by erwinschens on 10.10.15.
 */
public class MessageSender {

    /**
     * Sending message to context
     *
     * @param objectId Object id
     * @param message  Faces message
     */
    private void showMessage(final String objectId, final FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(objectId, message);
    }


    private FacesMessage getStringAsFacesMessage(final FacesMessage.Severity severity, final String title, final String message) {
        return new FacesMessage(severity, title, message);
    }

    public String getI18nMessage(String key) {
        return ResourceBundle.getBundle("com.alpha.translations").getString(key);
    }

    public void showI18nInfoMessage(final String titleKey, final String messageKey) {
        this.showMessage(null, getStringAsFacesMessage(FacesMessage.SEVERITY_INFO, getI18nMessage(titleKey), getI18nMessage(messageKey)));
    }

    public void showI18nWarnMessage(final String titleKey, final String messageKey) {
        this.showMessage(null, getStringAsFacesMessage(FacesMessage.SEVERITY_WARN, getI18nMessage(titleKey), getI18nMessage(messageKey)));
    }

    public void showI18nErrorMessage(final String titleKey, final String messageKey) {
        this.showMessage(null, getStringAsFacesMessage(FacesMessage.SEVERITY_ERROR, getI18nMessage(titleKey), getI18nMessage(messageKey)));
    }

    public void showI18nFatalMessage(final String titleKey, final String messageKey) {
        this.showMessage(null, getStringAsFacesMessage(FacesMessage.SEVERITY_FATAL, getI18nMessage(titleKey), getI18nMessage(messageKey)));
    }

}
