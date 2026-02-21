🚚 SpeedFast – Conexión Java con MySQL mediante JDBC

Proyecto desarrollado para la actividad formativa:

“Conectando aplicaciones Java con bases de datos mediante JDBC”

📌 Descripción

SpeedFast es una aplicación desarrollada en Java que permite registrar y gestionar pedidos, repartidores y entregas, conectando la interfaz gráfica con una base de datos MySQL utilizando JDBC.

La aplicación permite:
	•	Registrar pedidos.
	•	Registrar repartidores.
	•	Asociar entregas a pedidos.
	•	Guardar información de manera persistente en la base de datos.
	•	Consultar información almacenada.
  
  🛠 Tecnologías utilizadas
	•	Java
	•	IntelliJ IDEA
	•	MySQL
	•	MySQL Workbench
	•	JDBC (mysql-connector-j)

  🗄 Base de datos

Nombre de la base de datos:
speedfast_db

Tablas implementadas:
	•	repartidor
	•	pedido
	•	entrega

Relaciones:
	•	Un repartidor puede realizar muchas entregas.
	•	Un pedido puede tener una o más entregas.
	•	Cada entrega está asociada a un pedido y a un repartidor.

🔌 Conexión a la base de datos

La conexión se realiza mediante la clase:
ConexionDB

Utilizando:
DriverManager.getConnection(URL, USER, PASSWORD);

Se emplea PreparedStatement para realizar inserciones seguras y evitar inyección SQL.

📂 Estructura del proyecto
src/
│
├── main/
│   └── Main.java
│
├── modelo/
│   ├── Pedido.java
│   ├── Repartidor.java
│   └── Entrega.java
│
├── dao/
│   ├── ConexionDB.java
│   ├── PedidoDAO.java
│   ├── RepartidorDAO.java
│   └── EntregaDAO.java
│
└── vista/
    ├── VentanaPrincipal.java
    └── Formularios

▶ Cómo ejecutar el proyecto
	1.	Clonar el repositorio.
	2.	Crear la base de datos speedfast_db en MySQL.
	3.	Ejecutar el script de creación de tablas.
	4.	Configurar usuario y contraseña en ConexionDB.
	5.	Ejecutar la clase Main.

  
✅ Estado del proyecto

✔ Conexión exitosa con MySQL
✔ Inserción de datos desde la interfaz
✔ Persistencia real en la base de datos
✔ Implementación correcta de JDBC


## 📌 Autor

Javiera Gutierrez
