Participantes:
Noel Guevara: GF222473
Abner Waldemar: DL170325

--REVISAR CADENA DE CONEXION

Ocupe WildFly 33.0.0
https://github.com/wildfly/wildfly/releases/download/33.0.0.Final/wildfly-33.0.0.Final.zip
Open JDK 22
JakartaEE 10


Para Acceder a la API: (Si modifico el Application Path)

--Realiza un get de todas las filas de la tabla venta
http://localhost:8080/{ApplicationPath}}/API/venta

--Realiza un get de la fila con el id espeficico
http://localhost:8080/{ApplicationPath}}/API/venta/{id}




Con WildFly 33.0.0(Yo no modifique el Application Path)

--TABLA VENTA--

--Realiza un get de todas las filas de la tabla venta
http://localhost:8080/demo-1.0-SNAPSHOT/API/venta

--Realiza un get la tabla con el id elegido
http://localhost:8080/demo-1.0-SNAPSHOT/API/venta/{id}

--TABLA VIDEOJUEGOS--

--Realiza un get de todas las filas de la tabla videojuegos
http://localhost:8080/demo-1.0-SNAPSHOT/API/videojuego

--Realiza un get la tabla con el id elegido
http://localhost:8080/demo-1.0-SNAPSHOT/API/videojuego/{id}