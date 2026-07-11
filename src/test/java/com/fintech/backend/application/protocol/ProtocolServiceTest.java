package com.fintech.backend.application.protocol;

import com.fintech.backend.domain.model.Message;
import com.fintech.backend.infrastructure.protocol.ProtocolAdapter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class ProtocolServiceTest {

    @Mock
    private ProtocolAdapter protocolAdapter;

    @InjectMocks
    private ProtocolService protocolService;

    @Test
    void sendMessage_shouldCallAdapterSendMethod() {
        Message message = new Message("1", "Test message");
        protocolService.sendMessage(message);
        Mockito.verify(protocolAdapter).send(message);
    }

    @Test
    void receiveMessage_shouldCallAdapterReceiveMethod() {
        Mockito.when(protocolAdapter.receive()).thenReturn(new Message("1", "Test message received"));
        Message receivedMessage = protocolService.receiveMessage();
        assertNotNull(receivedMessage);
        assertEquals("Test message received", receivedMessage.content());
    }
}