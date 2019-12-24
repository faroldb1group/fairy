package com.db1group.fairy;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

final class MessageResourceFactory {

    private static final Map<Locale, ResourceBundle> CACHE = new HashMap<>();

    private MessageResourceFactory() {
    }

    static synchronized ResourceBundle getResourceBundle(Locale locale, String baseName) {
        if (isThereInCache(locale)) {
            return CACHE.get(locale);
        }
        ResourceBundle bundle = buildBundle(locale, baseName);
        addToCache(locale, bundle);
        return bundle;
    }

    private static boolean isThereInCache(Locale locale) {
        return CACHE.containsKey(locale);
    }

    private static ResourceBundle buildBundle(Locale locale, String baseName) {
        return ResourceBundle.getBundle(baseName, locale, YamlResourceBundle.Control.INSTANCE);
    }

    private static ResourceBundle addToCache(Locale locale, ResourceBundle bundle) {
        return CACHE.put(locale, bundle);
    }
}
