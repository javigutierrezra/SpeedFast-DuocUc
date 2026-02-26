Tablas implementadas:

Tabla: repartidor
	•	id (INT, AUTO_INCREMENT, PK)
	•	nombre (VARCHAR)

Tabla: pedido
	•	id (INT, AUTO_INCREMENT, PK)
	•	direccion (VARCHAR)
	•	tipo (ENUM: COMIDA, ENCOMIENDA, EXPRESS)
	•	estado (ENUM: PENDIENTE, EN_REPARTO, ENTREGADO)

Tabla: entrega
	•	id (INT, AUTO_INCREMENT, PK)
	•	id_pedido (FK)
	•	id_repartidor (FK)
	•	fecha (DATE)
	•	hora (TIME)

⸻

⚙ Funcionalidades Implementadas

1️⃣ Gestión de Repartidores
	•	Registrar repartidor
	•	Listar en JTable
	•	Actualizar
	•	Eliminar

2️⃣ Gestión de Pedidos
	•	Registrar pedido
	•	Seleccionar tipo y estado mediante JComboBox
	•	Listar en JTable
	•	Actualizar
	•	Eliminar

3️⃣ Gestión de Entregas
	•	Asociar Pedido y Repartidor
	•	Selección dinámica desde la base de datos
	•	Registro automático de fecha y hora
	•	Listar entregas
	•	Eliminar entrega

⸻

🔒 Buenas Prácticas Aplicadas
	•	Separación por capas (modelo / dao / vista)
	•	Uso de PreparedStatement para seguridad
	•	Manejo de excepciones con try-catch
	•	Cierre automático de recursos
	•	Validación básica de campos obligatorios
	•	Recarga automática de JTable después de cada operación

⸻

▶ Cómo Ejecutar el Proyecto
	1.	Crear la base de datos speedfast_db en MySQL.
	2.	Crear las tablas correspondientes.
	3.	Configurar correctamente la clase ConexionDB con:
	•	URL
	•	Usuario
	•	Contraseña
	4.	Ejecutar VentanaPrincipal.
	5.	Utilizar el menú principal para acceder a cada módulo.

⸻

🎯 Objetivo Académico

Este proyecto fue desarrollado como actividad sumativa para integrar:
	•	Programación Orientada a Objetos
	•	Acceso a datos con JDBC
	•	Implementación de CRUD
	•	Interfaz gráfica con Swing
	•	Persistencia en base de datos relacional

⸻

👩‍💻 Autora

Javiera Gutierrez
Proyecto académico - Gestión de pedidos SpeedFast
