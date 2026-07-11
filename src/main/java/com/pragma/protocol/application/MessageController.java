package com.pragma.protocol.application;

import com.pragma.protocol.domain.Message;
import com.pragma.protocol.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public Flux<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Mono<Message> getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Message> createMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }

    @PutMapping("/{id}")
    public Mono<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
        return messageService.updateMessage(id, message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMessage(@PathVariable Long id) {
        return messageService.deleteMessage(id);
    }
}