# gapsi_back
gapsi postulate job

---

## contenido

Contenido del siguiente codigo se un pequeño ejemplo de una rest api, elaborada con Spring Boot.

1. Controlador MessageController, en el cual se consumen los servicios como son:
  1.1.  Servicio de tipo Get que retorna, un mensaje "simula un mensaje de texto de "Bienvenido Candidato 01",  URL: **http://localhost:8080/info/welcome**.
  1.2.  Servicio de tipo Get que retorna, un mensaje "que simula datos de un realice del aplicativo",  URL: **http://localhost:8080/info**.
2. Controlador que retorna los servicios rest aplicables a un CRUD (altas, bajas,actualizaciones, detalle) de Proveedor () URL: **http://localhost:8080/api/provider**.
  2.1. Actualiza un proveedor UPDATE URL: **http://localhost:8080/api/provider/{id}**.
  2.2. Crea un proveedor POST URL: **http://localhost:8080/api/provider**.
  2.3. Enlista los proveedores GET URL: **http://localhost:8080/api/providers**.
  2.4. Elimina un proveedor mediante su Id DELETE URL: **http://localhost:8080/api/provider/{id}**.
  2.5. Elimina a todos los proveedores mediante DELETE URL: **http://localhost:8080/api/providers**.
  2.5. Recupera un proveedor en particular mediante su Id a todos los proveedores mediante DELETE URL: **http://localhost:8080/api/provider/{id}**.
4. Nota: Se puede utilizar alguna libreria como swagger, para asi tener una mejor referencia de los servicios.

---

## Especificaiones Tecnicas

El proyecto se encuentra construido en las siguientes especificaciones.

1. java 11, la version utilizada fue 11.0.5-zulu.
2. H2 Database
3. springframework.boot 2.7.9-SNAPSHOT with Spring Web MVC, Spring Data JPA
4. Apache Maven 3.6.1
5. El codigo se encuentra codificado en Java, con Mvn

---

## Consideraciones

Para que el back pueda ejecutarse se requiere lo siguiente.

1. Clonar el repositorio URL: https://github.com/tesgapsi/gapsi_back.git
2. Toda vez que se haya descargado el codigo debe posicionarse dentro del proyecto y mediante terminal ejecutar el comando mvn clean compile install, o en su defecto lo puede importar a su IDE que mas le agrade.
3. Como es una aplicacion con un tomcat embebido, no es necesario de un servidor de aplicaciones
4. Una forma muy practica de ejecutar el aplicativo es el siguiente comando java -Dspring.profiles.active=development -jar target/Gapsi-0.0.1-SNAPSHOT.jar
5. Nota: Solo el enviroment development cuanta con los parametros de configuracion de la H2 Database y toda vez que el aplicativo se encuentra ejecutando se puede acceder a la db de la siguente forma URL http://localhost:8080/h2-ui/login.do?jsessionid=e204576688fb400fc52475cb99b0afcd

---

## Requerimientos Tecnologicos

1. java 11
2. springframework.boot 2.7.9-SNAPSHOT
3.Apache Maven 3.6.1

