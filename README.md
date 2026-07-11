# Implementación de Protocolo de Comunicación no Convencional

El sistema de backend de una fintech necesita integrarse con un servicio externo que utiliza un protocolo de comunicación no convencional. El objetivo es implementar un protocolo de aplicación adicional a REST para mejorar la eficiencia y la comunicación en tiempo real con este servicio. El equipo de desarrollo, distribuido en diferentes ubicaciones, requiere que el candidato identifique las características del protocolo elegido, la estructura de los mensajes y el modelo de procesamiento.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Comunicación Avanzada: Implementando de Protocolo no convencionales |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 3-4 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: Un IDE o editor de código.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Verifica que el proyecto arranca sin errores.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Exploración y Selección de Protocolo

**Objetivo:** Identificar y seleccionar un protocolo de comunicación no convencional que se ajuste a las necesidades del sistema.

**Tiempo estimado:** 1 hora

**Instrucciones:**

- Investiga diferentes protocolos de comunicación no convencionales (STOMP, RSocket, gRPC, WebSocket, WS-SOAP, MQTT, AMQP, XMPP, WebHook, GraphQL).
- Evalúa las características, ventajas y desventajas de cada protocolo.
- Selecciona el protocolo que mejor se adapte a las necesidades del sistema y justifica tu elección.

**Entregable:** Un documento que describa el protocolo seleccionado, sus características y la justificación de la elección.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la latencia, el rendimiento, la escalabilidad y la complejidad de implementación al evaluar los protocolos.
- Piensa en cómo el protocolo seleccionado afectará la comunicación en tiempo real y la eficiencia del sistema.

</details>

### Fase 2: Implementación del Protocolo

**Objetivo:** Implementar el protocolo seleccionado en el sistema de backend.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura el entorno de desarrollo para utilizar el protocolo seleccionado.
- Implementa la estructura de mensajes y el modelo de procesamiento según las especificaciones del protocolo.
- Realiza pruebas para asegurar que la implementación funciona correctamente.

**Entregable:** Un sistema de backend que implementa el protocolo seleccionado y pasa las pruebas de integración.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los posibles errores y casos límite al implementar el protocolo.
- Asegúrate de que la implementación sea escalable y eficiente.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es el protocolo seleccionado y cuáles son sus características principales?
- **paraQueSirve**: ¿Para qué sirve el protocolo seleccionado en el contexto del sistema de backend?
- **comoSeUsa**: ¿Cómo se usa el protocolo seleccionado en la implementación?
- **erroresComunes**: ¿Qué errores comunes pueden ocurrir al implementar el protocolo y cómo los manejaste?
- **queDecisionesImplica**: ¿Qué decisiones implica la selección y la implementación del protocolo?

## Criterios de Evaluacion

- Selección y justificación del protocolo.
- Implementación correcta del protocolo.
- Manejo de errores comunes.
- Escalabilidad y eficiencia de la implementación.

---

*Reto generado automaticamente por Challenge Generator - Pragma*
