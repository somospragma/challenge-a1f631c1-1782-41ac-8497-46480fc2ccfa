package com.fintech.backend.application.protocol;

import com.fintech.backend.domain.model.Message;
import com.fintech.backend.infrastructure.protocol.ProtocolAdapter;
import org.springframework.stereotype.Service;

@Service
public class ProtocolService {
    private final ProtocolAdapter protocolAdapter;

    public ProtocolService(ProtocolAdapter protocolAdapter) {
        this.protocolAdapter = protocolAdapter;
    }

    public void sendMessage(Message message) {
        protocolAdapter.send(message);
    }

    public Message receiveMessage() {
        return protocolAdapter.receive();
    }
}