package com.db1group.fairy;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class MessageResourceTest {

    private MessageResource messageResource = new MessageResource(MessageResource.DEFAULT_BASE_NAME);

    @Test
    void new_singleton() {
        assertNotNull(MessageResource.INSTANCE);
    }

    @Test
    void new_fromBaseName() {
        assertNotNull(new MessageResource("i18n.messages"));
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
}