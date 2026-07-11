package com.fintech.backend.infrastructure.protocol;

import com.fintech.backend.domain.model.Message;

public interface ProtocolAdapter {
    void send(Message message);
    Message receive();
}