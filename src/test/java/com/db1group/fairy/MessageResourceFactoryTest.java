package com.db1group.fairy;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessageResourceFactoryTest {

    @Test
    void getResourceBundle_shouldReturnNewFromCache() {
        ResourceBundle resourceBundleOne = MessageResourceFactory.getResourceBundle(Locale.US, "i18n.messages");
        assertNotNull(resourceBundleOne);

        ResourceBundle resourceBundleTwo = MessageResourceFactory.getResourceBundle(Locale.US, "i18n.messages");
        assertNotNull(resourceBundleTwo);

        assertEquals(resourceBundleOne, resourceBundleTwo);
    }
}