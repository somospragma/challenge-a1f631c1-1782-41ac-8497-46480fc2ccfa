# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto corregido y listo para compilar.

---

```
Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación o descripciones sin código, genera los archivos
correspondientes sin aplicar análisis de compilación
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
// === ARCHIVO: src/main/java/com/pragma/protocol/application/MessageService.java ===
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

// === ARCHIVO: src/main/java/com/pragma/protocol/domain/Message.java ===
package com.pragma.protocol.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

// === ARCHIVO: src/main/java/com/pragma/protocol/infrastructure/MessageRepository.java ===
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

// === ARCHIVO: src/main/resources/config/application.yml ===
server:
  port: 8080
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    username: sa
    password:
    driver-class-name: org.h2.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true

// === ARCHIVO: src/main/java/com/pragma/protocol/application/MessageController.java ===
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

// === ARCHIVO: src/test/java/com/pragma/protocol/application/MessageServiceTest.java ===
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

// === ARCHIVO: src/test/java/com/pragma/protocol/domain/MessageTest.java ===
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

// === ARCHIVO: src/test/java/com/pragma/protocol/infrastructure/MessageRepositoryTest.java ===
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

```
