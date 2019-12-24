package com.db1group.fairy;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;

public class MessageResource {

    public static final String DEFAULT_BASE_NAME = "i18n.messages";

    public static final MessageResource INSTANCE = new MessageResource();

    private final String baseName;

    public MessageResource() {
        this(DEFAULT_BASE_NAME);
    }

    public MessageResource(String baseName) {
        this.baseName = baseName;
    }

    public String getMessage(String key) {
        return this.getMessage(key, Locale.getDefault());
    }

    public String getMessage(String key, Object... arguments) {
        return this.getMessage(key, Locale.getDefault(), arguments);
    }

    public String getMessage(String key, Locale locale) {
        return this.getMessage(key, locale, key);
    }

    public String getMessage(String key, Locale locale, Object... arguments) {
        return this.getMessage(key, locale, key, arguments);
    }

    public String getMessage(String key, String defaultMessage) {
        return this.getMessage(key, Locale.getDefault(), defaultMessage);
    }

    public String getMessage(String key, String defaultMessage, Object... arguments) {
        return this.getMessage(key, Locale.getDefault(), defaultMessage, arguments);
    }

    public String getMessage(String key, Locale locale, String defaultMessage) {
        Objects.requireNonNull(defaultMessage);
        ResourceBundle resourceBundle = getResourceBundle(locale);
        String message = getMessage(key, resourceBundle);
        return Objects.nonNull(message) && !message.isEmpty() ? message : defaultMessage;
    }

    public String getMessage(String key, Locale locale, String defaultMessage, Object... arguments) {
        Objects.requireNonNull(arguments);
        String message = this.getMessage(key, locale, defaultMessage);
        return MessageFormat.format(message, arguments);
    }

    private ResourceBundle getResourceBundle(Locale locale) {
        return MessageResourceFactory.getResourceBundle(locale, baseName);
    }

    private String getMessage(String key, ResourceBundle resourceBundle) {
        try {
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }
}
