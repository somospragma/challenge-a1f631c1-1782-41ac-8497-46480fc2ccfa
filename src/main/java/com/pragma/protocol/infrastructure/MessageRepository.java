package com.pragma.protocol.infrastructure;

import com.pragma.protocol.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    Flux<Message> findAll();
    Mono<Message> findById(Long id);
    Mono<Message> save(Message message);
    Mono<Void> deleteById(Long id);
}