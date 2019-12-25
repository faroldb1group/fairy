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

    private MessageResource messageResource = MessageResource.ofBaseName(MessageResource.DEFAULT_BASE_NAME);

    @Test
    void of_default() {
        assertNotNull(MessageResource.of());
    }

    @Test
    void of_baseName() {
        assertNotNull(MessageResource.ofBaseName(MessageResource.DEFAULT_BASE_NAME));
    }

    @Test
    void ofBaseName_throwException_whenBaseNameNull() {
        assertThrows(NullPointerException.class, () -> MessageResource.ofBaseName(null));
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
    void arguments_of_1() {
        assertArrayEquals(new String[]{"1"}, MessageResource.Arguments.of("1"));
    }

    @Test
    void arguments_of_2() {
        assertArrayEquals(new String[]{"1", "2"}, MessageResource.Arguments.of("1", "2"));
    }

    @Test
    void arguments_of_3() {
        assertArrayEquals(new String[]{"1", "2", "3"}, MessageResource.Arguments.of("1", "2", "3"));
    }

    @Test
    void arguments_of_4() {
        assertArrayEquals(new String[]{"1", "2", "3", "4"}, MessageResource.Arguments.of("1", "2", "3", "4"));
    }

    @Test
    void arguments_of_5() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5"}, MessageResource.Arguments.of("1", "2", "3", "4", "5"));
    }

    @Test
    void arguments_of_6() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, MessageResource.Arguments.of("1", "2", "3", "4", "5", "6"));
    }

    @Test
    void arguments_of_7() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7"}, MessageResource.Arguments.of("1", "2", "3", "4", "5", "6", "7"));
    }

    @Test
    void arguments_of_8() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}, MessageResource.Arguments.of("1", "2", "3", "4", "5", "6", "7", "8"));
    }

    @Test
    void arguments_of_9() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}, MessageResource.Arguments.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    @Test
    void arguments_of_10() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}, MessageResource.Arguments.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    }

    @Test
    void arguments_of_varargs() {
        assertArrayEquals(new String[]{"one", "two"}, MessageResource.Arguments.of("one", "two"));
    }

    @Test
    void arguments_of_varargs_shouldThrowException_whenArgumentsIsNull() {
        assertThrows(NullPointerException.class, () -> MessageResource.Arguments.of(ARGUMENTS_NULL));
    }
}
