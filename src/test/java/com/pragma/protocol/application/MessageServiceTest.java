package com.pragma.protocol.application;

import com.pragma.protocol.domain.Message;
import com.pragma.protocol.infrastructure.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

@SpringBootTest
class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @MockBean
    private MessageRepository messageRepository;

    private Message message;

    @BeforeEach
    void setUp() {
        message = new Message();
        message.setId(1L);
        message.setContent("Test Message");
    }

    @Test
    void getAllMessages() {
        Mockito.when(messageRepository.findAll()).thenReturn(Flux.just(message));
        StepVerifier.create(messageService.getAllMessages())
               .expectNextCount(1)
               .verifyComplete();
    }

    @Test
    void getMessageById() {
        Mockito.when(messageRepository.findById(1L)).thenReturn(Mono.just(message));
        StepVerifier.create(messageService.getMessageById(1L))
               .expectNext(message)
               .verifyComplete();
    }

    @Test
    void createMessage() {
        Mockito.when(messageRepository.save(message)).thenReturn(Mono.just(message));
        StepVerifier.create(messageService.createMessage(message))
               .expectNext(message)
               .verifyComplete();
    }

    @Test
    void updateMessage() {
        Mockito.when(messageRepository.findById(1L)).thenReturn(Mono.just(message));
        Mockito.when(messageRepository.save(message)).thenReturn(Mono.just(message));
        StepVerifier.create(messageService.updateMessage(1L, message))
               .expectNext(message)
               .verifyComplete();
    }

    @Test
    void deleteMessage() {
        Mockito.when(messageRepository.deleteById(1L)).thenReturn(Mono.empty());
        StepVerifier.create(messageService.deleteMessage(1L))
               .verifyComplete();
    }
}