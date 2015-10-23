package com.alpha.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by erwinschens on 23.10.15.
 */
public class FlashMessage {

    public static void showFlashInfo(String titleKey, String textKey) {
        new MessageSender().showI18nInfoMessage(titleKey, textKey);
    }

    public static void showFlashWarn(String titleKey, String textKey) {
        new MessageSender().showI18nWarnMessage(titleKey, textKey);
    }

    public static void showFlashError(String titleKey, String textKey) {
        new MessageSender().showI18nErrorMessage(titleKey, textKey);
    }

    public static void showFlashFatal(String titleKey, String textKey) {
        new MessageSender().showI18nFatalMessage(titleKey, textKey);
    }

}
