package com.pragma.protocol.application;

import com.pragma.protocol.domain.Message;
import com.pragma.protocol.infrastructure.MessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Flux<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Mono<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public Mono<Message> createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Mono<Message> updateMessage(Long id, Message message) {
        return messageRepository.findById(id)
               .flatMap(existingMessage -> {
                    existingMessage.setContent(message.getContent());
                    return messageRepository.save(existingMessage);
                });
    }

    public Mono<Void> deleteMessage(Long id) {
        return messageRepository.deleteById(id);
    }
}