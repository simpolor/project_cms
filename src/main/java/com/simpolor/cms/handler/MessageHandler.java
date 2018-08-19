package com.simpolor.cms.handler;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {

    private static Locale locale = Locale.getDefault();

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key) throws NoSuchMessageException {
        return messageSource.getMessage(key, null, null, locale);
    }

    public String getMessage(String key, Object[] data) throws NoSuchMessageException {
        return messageSource.getMessage(key, data, locale);
    }

    public String getMessage(String key, Object[] data, String defaultMsg) throws NoSuchMessageException {
        return messageSource.getMessage(key, data, defaultMsg, locale);
    }

    public String getMessage(String key, Object[] data, Locale locale) throws NoSuchMessageException {
        return messageSource.getMessage(key, data, locale);
    }

    public String getMessage(String key, Object[] data, String defaultMsg, Locale locale) {
        return messageSource.getMessage(key, data, defaultMsg, locale);
    }

}
