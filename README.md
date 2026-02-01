SpeedFast – Semana 4

📌 Ejecutando tareas en paralelo con hilos en Java

Este proyecto corresponde a la Semana 4 del caso SpeedFast, una empresa dedicada al reparto de pedidos de comida, encomiendas y compras express. En esta etapa se incorporó programación concurrente en Java, permitiendo simular múltiples repartidores realizando entregas al mismo tiempo mediante hilos.

El objetivo principal es demostrar el uso de:
	•	Programación orientada a objetos
	•	Interfaces y clases abstractas
	•	Hilos con Runnable
	•	Ejecución concurrente con ExecutorService

⸻

🧠 Descripción del sistema

El sistema modela distintos tipos de pedidos y repartidores que los entregan de forma simultánea:

🔹 Tipos de pedidos

Todos los pedidos heredan de la clase abstracta Pedido:
	•	PedidoComida
	•	PedidoEncomienda
	•	PedidoExpress

Cada pedido contiene:
	•	idPedido
	•	direccionEntrega
	•	distanciaKm

Y métodos como:
	•	calcularTiempoEntrega()
	•	mostrarResumen()

🔹 Interfaces implementadas
	•	Despachable → permite despachar pedidos
	•	Cancelable → permite cancelar pedidos
	•	Rastreable → permite rastrear y ver historial del pedido

🔹 Concurrencia

Cada repartidor es representado por la clase Repartidor, la cual:
	•	Implementa la interfaz Runnable
	•	Recorre su lista de pedidos
	•	Simula la entrega usando Thread.sleep() con tiempos aleatorios
	•	Muestra el progreso en consola

Los repartidores se ejecutan en paralelo usando ExecutorService desde la clase Main.

⸻

🗂️ Estructura del proyecto

speedfast/
 ├── src/
 │    ├── Main.java
 │    ├── Repartidor.java
 │    ├── pedidos/
 │    │    ├── Pedido.java
 │    │    ├── PedidoComida.java
 │    │    ├── PedidoEncomienda.java
 │    │    └── PedidoExpress.java
 │    └── interfaces/
 │         ├── Despachable.java
 │         ├── Cancelable.java
 │         └── Rastreable.java


⸻

▶️ Ejecución del programa

Requisitos
	•	Java JDK 11 o superior
	•	IntelliJ IDEA

Pasos para ejecutar
	1.	Abrir la carpeta speedfast en IntelliJ
	2.	Verificar que el SDK de Java esté configurado
	3.	Abrir Main.java
	4.	Presionar el botón ▶️ Run

⸻

🖥️ Ejemplo de salida en consola

=== SpeedFast - Simulación de Entregas Concurrentes ===
🚴 Repartidor Carlos inicia su ruta...
🚴 Repartidor Ana inicia su ruta...
🚴 Repartidor Luis inicia su ruta...
📦 Carlos entregando pedido #1
📦 Ana entregando pedido #3
📦 Luis entregando pedido #5
⏳ Carlos tardará 3 segundos...
...
🏁 Repartidor Carlos terminó su ruta.

La salida varía en cada ejecución debido a los tiempos aleatorios y la ejecución concurrente de los hilos.

⸻

🎯 Objetivo académico

Este proyecto permite comprender:
	•	El uso de herencia y polimorfismo en Java
	•	La implementación de interfaces
	•	La creación y ejecución de hilos con Runnable
	•	La gestión de concurrencia con ExecutorService
	•	La simulación de procesos multitarea en un entorno realista

⸻

👩‍💻 Autor

Javiera Gutierrez
Proyecto académico – Programación en Java
Semana 4 – SpeedFast

⸻

📦 Repositorio

Este proyecto forma parte de un repositorio que contiene el desarrollo del sistema SpeedFast organizado por semanas:

SpeedFastRepo/
 ├── semana 3/
 └── semana 4/

Cada carpeta representa una etapa del desarrollo del sistema.
