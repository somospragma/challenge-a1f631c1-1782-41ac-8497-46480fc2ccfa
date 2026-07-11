package com.fintech.backend.application.rest;

import com.fintech.backend.application.protocol.ProtocolService;
import com.fintech.backend.domain.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/messages")
public class Controller {

    private final ProtocolService protocolService;

    @Autowired
    public Controller(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDTO) {
        var message = new com.fintech.backend.domain.model.Message(UUID.randomUUID().toString(), messageDTO.content());
        protocolService.sendMessage(message);
        return ResponseEntity.ok(messageDTO);
    }

    @GetMapping
    public ResponseEntity<MessageDTO> receiveMessage() {
        var message = protocolService.receiveMessage();
        return ResponseEntity.ok(new MessageDTO(message.id(), message.content()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateMessage(@PathVariable String id, @RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(messageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}