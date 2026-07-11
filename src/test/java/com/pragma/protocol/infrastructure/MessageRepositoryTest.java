package com.pragma.protocol.infrastructure;

import com.pragma.protocol.domain.Message;
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
class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    private Message message;

    @BeforeEach
    void setUp() {
        message = new Message();
        message.setId(1L);
        message.setContent("Test Message");
    }

    @Test
    void findAll() {
        Mockito.when(messageRepository.findAll()).thenReturn(Flux.just(message));
        StepVerifier.create(messageRepository.findAll())
               .expectNextCount(1)
               .verifyComplete();
    }

    @Test
    void findById() {
        Mockito.when(messageRepository.findById(1L)).thenReturn(Mono.just(message));
        StepVerifier.create(messageRepository.findById(1L))
               .expectNext(message)
               .verifyComplete();
    }

    @Test
    void save() {
        Mockito.when(messageRepository.save(message)).thenReturn(Mono.just(message));
        StepVerifier.create(messageRepository.save(message))
               .expectNext(message)
               .verifyComplete();
    }

    @Test
    void deleteById() {
        Mockito.when(messageRepository.deleteById(1L)).thenReturn(Mono.empty());
        StepVerifier.create(messageRepository.deleteById(1L))
               .verifyComplete();
    }
}