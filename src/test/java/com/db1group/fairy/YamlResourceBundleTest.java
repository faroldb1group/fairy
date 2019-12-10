package com.db1group.fairy;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

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
    void handeKeySet_shouldReturnKeySet_withMessageOneKey() {
        YamlResourceBundle bundle = YamlResourceBundleTestDataBuilder.yamlResourceBundleWithMessages();
        assertTrue(bundle.handleKeySet().contains("message.one"));
    }

    @Test
    void handeKeySet_shouldReturnKeySet_withMessageTwoKey() {
        YamlResourceBundle bundle = YamlResourceBundleTestDataBuilder.yamlResourceBundleWithMessages();
        assertTrue(bundle.handleKeySet().contains("message.two"));
    }

    @Test
    void handeKeySet_shouldReturnKeySet_withMessageOnlyDefaultKey() {
        YamlResourceBundle bundle = YamlResourceBundleTestDataBuilder.yamlResourceBundleWithMessages();
        assertTrue(bundle.handleKeySet().contains("message.only.default"));
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
    void control_newBundle_shouldCreateFromYaml_en_US() throws IllegalAccessException, IOException, InstantiationException {
        ResourceBundle resourceBundle = YamlResourceBundle.Control.INSTANCE.newBundle("i18n.messages", new Locale("en", "US"), "yaml", YamlResourceBundle.class.getClassLoader(), false);
        assertNotNull(resourceBundle);
        assertTrue(resourceBundle instanceof YamlResourceBundle);
    }

    @Test
    void control_newBundle_shouldCreateFromYml_pt_BR() throws IllegalAccessException, IOException, InstantiationException {
        ResourceBundle resourceBundle = YamlResourceBundle.Control.INSTANCE.newBundle("i18n.messages", new Locale("pt", "BR"), "yml", YamlResourceBundle.class.getClassLoader(), false);
        assertNotNull(resourceBundle);
        assertTrue(resourceBundle instanceof YamlResourceBundle);
    }

    @Test
    void control_newBundle_shouldCreateFromProperties() throws IllegalAccessException, IOException, InstantiationException {
        ResourceBundle resourceBundle = YamlResourceBundle.Control.INSTANCE.newBundle("i18n.messages", new Locale("en", "UK"), "java.properties", YamlResourceBundle.class.getClassLoader(), false);
        assertNotNull(resourceBundle);
        assertTrue(resourceBundle instanceof PropertyResourceBundle);
    }

    @Test
    void resourceBundle_shouldReturn_messageOnlyDefault_fromDefaultFile() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.messages", YamlResourceBundle.Control.INSTANCE);
        assertEquals("message only default", resourceBundle.getString("message.only.default"));
    }


    @Test
    void resourceBundle_shouldReturn_messageOne_fromDefaultFile() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.messages", new Locale("", ""), YamlResourceBundle.Control.INSTANCE);
        assertEquals("one default", resourceBundle.getString("message.one"));
    }

    @Test
    void resourceBundle_shouldReturn_messageOne_fromEnUSFile() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.messages", new Locale("en", "US"), YamlResourceBundle.Control.INSTANCE);
        assertEquals("one", resourceBundle.getString("message.one"));
    }

    @Test
    void resourceBundle_shouldReturn_messageOne_fromPtBRFile() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.messages", new Locale("pt", "BR"), YamlResourceBundle.Control.INSTANCE);
        assertEquals("um", resourceBundle.getString("message.one"));
    }

    @Test
    void resourceBundle_shouldReturn_message_fromPropertiesFile() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.messages", new Locale("en", "UK"), YamlResourceBundle.Control.INSTANCE);
        assertEquals("Message from properties", resourceBundle.getString("message.properties"));
    }
}