package com.db1group.fairy;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


class MessageResourceTest {

    private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

    private static final String[] ARGUMENTS = {"an argument"};

    private static final String DEFAULT_MESSAGE = "default message";

    private static final Locale LOCALE_NULL = null;

    private static final Object[] ARGUMENTS_NULL = null;

    private static final String DEFAULT_MESSAGE_NULL = null;

    private MessageResource messageResource = new MessageResource(MessageResource.DEFAULT_BASE_NAME);

    @Test
    void new_default() {
        assertNotNull(new MessageResource());
    }

    @Test
    void new_baseName() {
        assertNotNull(new MessageResource(MessageResource.DEFAULT_BASE_NAME));
    }

    @Test
    void new_baseName_throwException_whenBaseNameNull() {
        assertThrows(NullPointerException.class, () -> new MessageResource(null));
    }

    @Test
    void getMessage_key_shouldReturnMessage() {
        Locale.setDefault(Locale.US);
        assertEquals("one", messageResource.getMessage("message.one"));
    }

    @Test
    void getMessage_key_shouldReturnKeyWhenNotFoundInMessagesFile() {
        Locale.setDefault(Locale.US);
        assertEquals("message.not.found.in.file", messageResource.getMessage("message.not.found.in.file"));
    }

    @Test
    void getMessage_key_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage(null));
    }

    @Test
    void getMessage_key_arguments_shouldReturnMessage() {
        Locale.setDefault(Locale.US);
        assertEquals("message with argument - an argument", messageResource.getMessage("message.argument", ARGUMENTS));
    }

    @Test
    void getMessage_key_arguments_shouldReturnKeyWhenNotFoundInMessagesFile() {
        Locale.setDefault(Locale.US);
        assertEquals("message.not.found.in.file", messageResource.getMessage("message.not.found.in.file", ARGUMENTS));
    }

    @Test
    void getMessage_key_arguments_shouldThrowNullPointerException_whenKeyIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage(null, ARGUMENTS));
    }

    @Test
    void getMessage_key_arguments_shouldThrowNullPointerException_whenArgumentsIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", ARGUMENTS_NULL));
    }

    @Test
    void getMessage_key_locale_shouldReturnMessage() {
        assertEquals("um", messageResource.getMessage("message.one", LOCALE_PT_BR));
    }

    @Test
    void getMessage_key_locale_shouldReturnKey_whenNotFoundInMessagesFile() {
        assertEquals("message.not.found.in.file", messageResource.getMessage("message.not.found.in.file", LOCALE_PT_BR));
    }

    @Test
    void getMessage_key_locale_shouldThrowNullPointerException_whenKeyIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage(null, LOCALE_PT_BR));
    }

    @Test
    void getMessage_key_locale_shouldThrowNullPointerException_whenLocaleIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", LOCALE_NULL));
    }

    @Test
    void getMessage_key_locale_arguments_shouldReturnMessage() {
        assertEquals("mensagem com argumento - an argument", messageResource.getMessage("message.argument", LOCALE_PT_BR, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_arguments_shouldReturnKey_whenNotFoundInMessagesFile() {
        assertEquals("message.not.found.in.file", messageResource.getMessage("message.not.found.in.file", LOCALE_PT_BR, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_arguments_shouldThrowNullPointerException_whenKeyIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage(null, LOCALE_PT_BR, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_arguments_shouldThrowNullPointerException_whenLocaleIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", LOCALE_NULL, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_arguments_shouldThrowNullPointerException_whenArgumentsIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", LOCALE_PT_BR, ARGUMENTS_NULL));
    }

    @Test
    void getMessage_key_defaultMessage_shouldReturnMessage() {
        Locale.setDefault(Locale.US);
        assertEquals("one", messageResource.getMessage("message.one", DEFAULT_MESSAGE));
    }

    @Test
    void getMessage_key_defaultMessage_shouldReturnDefaultMessage_whenNotFoundInMessagesFile() {
        Locale.setDefault(Locale.US);
        assertEquals(DEFAULT_MESSAGE, messageResource.getMessage("message.not.found.in.file", DEFAULT_MESSAGE));
    }

    @Test
    void getMessage_key_defaultMessage_shouldThrowNullPointerException_whenKeyIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage(null, DEFAULT_MESSAGE));
    }

    @Test
    void getMessage_key_defaultMessage_shouldThrowNullPointerException_whenDefautMessageIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", LOCALE_PT_BR, DEFAULT_MESSAGE_NULL));
    }

    @Test
    void getMessage_key_defaultMessage_arguments_shouldReturnMessage() {
        Locale.setDefault(Locale.US);
        assertEquals("one", messageResource.getMessage("message.one", DEFAULT_MESSAGE, ARGUMENTS));
    }

    @Test
    void getMessage_key_defaultMessage_arguments_shouldReturnDefaultMessage_whenNotFoundInMessagesFile() {
        Locale.setDefault(Locale.US);
        assertEquals(DEFAULT_MESSAGE, messageResource.getMessage("message.not.found.in.file", DEFAULT_MESSAGE, ARGUMENTS));
    }

    @Test
    void getMessage_key_defaultMessage_arguments_shouldThrowNullPointerException_whenKeyIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage(null, DEFAULT_MESSAGE, ARGUMENTS));
    }

    @Test
    void getMessage_key_defaultMessage_arguments_shouldThrowNullPointerException_whenDefautMessageIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", DEFAULT_MESSAGE_NULL, ARGUMENTS));
    }

    @Test
    void getMessage_key_defaultMessage_arguments_shouldThrowNullPointerException_whenArgumentsIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", DEFAULT_MESSAGE, ARGUMENTS_NULL));
    }

    @Test
    void getMessage_key_locale_defaultMessage_arguments_shouldReturnMessage() {
        assertEquals("mensagem com argumento - an argument", messageResource.getMessage("message.argument", LOCALE_PT_BR, DEFAULT_MESSAGE, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_defaultMessage_arguments_shouldReturDefaultMessage_whenNotFoundInMessagesFile() {
        assertEquals(DEFAULT_MESSAGE, messageResource.getMessage("message.not.found.in.file", LOCALE_PT_BR, DEFAULT_MESSAGE, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_defaultMessage_arguments_shouldThrowNullPointerException_whenKeyIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage(null, LOCALE_PT_BR, DEFAULT_MESSAGE, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_defaultMessage_arguments_shouldThrowNullPointerException_whenLocaleIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", LOCALE_NULL, DEFAULT_MESSAGE, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_defaultMessage_arguments_shouldThrowNullPointerException_whenDefautMessageIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", LOCALE_PT_BR, DEFAULT_MESSAGE_NULL, ARGUMENTS));
    }

    @Test
    void getMessage_key_locale_defaultMessage_arguments_shouldThrowNullPointerException_whenArgumentsIsNull() {
        assertThrows(NullPointerException.class, () -> messageResource.getMessage("key", LOCALE_PT_BR, DEFAULT_MESSAGE, ARGUMENTS_NULL));
    }

    @Test
    void arguments_of_shouldReturnArray() {
        assertArrayEquals(new String[]{"one", "two"}, MessageResource.Arguments.of("one", "two"));
    }


    @Test
    void arguments_of_shouldThrowException_whenArgumentsIsNull() {
        assertThrows(NullPointerException.class, () -> MessageResource.Arguments.of(ARGUMENTS_NULL));
    }
}
