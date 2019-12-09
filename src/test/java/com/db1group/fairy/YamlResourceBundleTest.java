package com.db1group.fairy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class YamlResourceBundleTest {

    @Test
    void new_shouldThrowExceptionInputStreamIsRequired() {
        assertThrows(NullPointerException.class, () -> new YamlResourceBundle(null));
    }

    @Test
    void new_instance() {
        assertNotNull(new YamlResourceBundle(YamlResourceBundleTestDataBuilder.messagesStream()));
    }

    @Test
    void getKeys_shouldReturnKeys() {
        YamlResourceBundle bundle = YamlResourceBundleTestDataBuilder.yamlResourceBundleWithMessages();
        assertEquals(Arrays.asList("message.two", "message.one", "message.only.default"), Collections.list(bundle.getKeys()));
    }

    @Test
    void handleGetObject_shouldThrowExceptionWhenKeyNull() {
        YamlResourceBundle bundle = YamlResourceBundleTestDataBuilder.yamlResourceBundleWithMessages();
        assertThrows(NullPointerException.class, () -> bundle.handleGetObject(null));
    }

    @Test
    void handleGetObject_shouldReturnNullWhenKeyNotFound() {
        YamlResourceBundle bundle = YamlResourceBundleTestDataBuilder.yamlResourceBundleWithMessages();
        assertNull(bundle.handleGetObject("key.not.found"));
    }

    @Test
    void handleGetObject_shouldReturnValueOfKey() {
        YamlResourceBundle bundle = YamlResourceBundleTestDataBuilder.yamlResourceBundleWithMessages();
        assertEquals("one default", bundle.handleGetObject("message.one"));
    }

    @Test
    void control_new_shouldReturnInstance() {
        assertNotNull(YamlResourceBundle.Control.INSTANCE);
    }

    @Test
    void control_getFormats_shouldContainsYaml() {
        assertTrue(YamlResourceBundle.Control.INSTANCE.getFormats("basename").contains("yaml"));
    }

    @Test
    void control_getFormats_shouldContainsYml() {
        assertTrue(YamlResourceBundle.Control.INSTANCE.getFormats("basename").contains("yml"));
    }

    @Test
    void control_getFormats_shouldContainsJavaClass() {
        assertTrue(YamlResourceBundle.Control.INSTANCE.getFormats("basename").contains("java.class"));
    }

    @Test
    void control_getFormats_shouldContainsJavaProperties() {
        assertTrue(YamlResourceBundle.Control.INSTANCE.getFormats("basename").contains("java.properties"));
    }

    @Test
    void control_newBundle_shouldCreateFromYaml() {

    }
}