package com.pragma.protocol.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    private Message message;

    @BeforeEach
    void setUp() {
        message = new Message();
        message.setId(1L);
        message.setContent("Test Message");
    }

    @Test
    void getId() {
        assertEquals(1L, message.getId());
    }

    @Test
    void setId() {
        message.setId(2L);
        assertEquals(2L, message.getId());
    }

    @Test
    void getContent() {
        assertEquals("Test Message", message.getContent());
    }

    @Test
    void setContent() {
        message.setContent("New Test Message");
        assertEquals("New Test Message", message.getContent());
    }
}