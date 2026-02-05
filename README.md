# SpeedFast – Semana 5  
## Sincronizando procesos en sistemas concurrentes

### Descripción de la actividad
Esta actividad corresponde a la **quinta semana** del módulo de Programación en Java y tiene como objetivo aplicar **mecanismos de sincronización** en sistemas concurrentes.

El sistema simula el funcionamiento de la empresa **SpeedFast**, donde múltiples repartidores trabajan en paralelo retirando pedidos desde una **zona de carga compartida**. Para evitar errores como entregas duplicadas, se implementan técnicas de control de concurrencia que garantizan que cada pedido sea atendido por un único repartidor.

---

### Objetivo
Diseñar e implementar un sistema concurrente en Java que:
- Utilice `Thread`, `Runnable` y sincronización.
- Controle el acceso a un recurso compartido.
- Evite condiciones de carrera.
- Garantice la integridad de los datos durante el proceso de despacho.

---

### Tecnologías utilizadas
- Java
- IntelliJ IDEA
- Programación concurrente
- ExecutorService
- Sincronización con `synchronized`

---

### Estructura del proyecto
src
└── speedfast
├── Main.java
├── Pedido.java
├── EstadoPedido.java
├── ZonaDeCarga.java
└── Repartidor.java
---

### Descripción de las clases

#### Pedido
Representa una encomienda del sistema. Contiene un identificador, dirección de entrega y un estado que indica su progreso dentro del proceso de despacho.

#### EstadoPedido
Enum que define los posibles estados de un pedido:
- PENDIENTE
- EN_REPARTO
- ENTREGADO

#### ZonaDeCarga
Recurso compartido donde se almacenan los pedidos pendientes. El acceso a esta clase está sincronizado para evitar que más de un repartidor retire el mismo pedido.

#### Repartidor
Representa a un repartidor que trabaja en un hilo independiente. Retira pedidos desde la zona de carga, simula la entrega y actualiza el estado del pedido.

#### Main
Clase principal que inicializa el sistema, crea los pedidos, instancia los repartidores y ejecuta la simulación concurrente utilizando `ExecutorService`.

---

### Funcionamiento del sistema
1. Los pedidos son agregados a la zona de carga.
2. Varios repartidores trabajan en paralelo.
3. Cada repartidor retira un pedido de forma sincronizada.
4. El pedido pasa por los estados EN_REPARTO y ENTREGADO.
5. El proceso finaliza cuando todos los pedidos han sido entregados.

---

### Resultado esperado
El sistema garantiza que:
- Cada pedido sea entregado una sola vez.
- No existan conflictos por acceso concurrente.
- Todos los pedidos finalicen en estado ENTREGADO.

Al finalizar la ejecución, se muestra el mensaje:

**"Todos los pedidos han sido entregados correctamente"**

---

### Autor
Javiera Gutierrez

---

### Observaciones
Este proyecto demuestra el uso correcto de programación concurrente y sincronización en Java, aplicando buenas prácticas para el manejo de recursos compartidos.

