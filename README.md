# Evaluación JAVA - API RESTful de Creación de Usuarios


Evaluación JAVA - API RESTful de Creación de Usuarios
Este proyecto consiste en una aplicación Java que expone una API RESTful para la creación de usuarios. La aplicación utiliza Spring Boot como framework, JPA para la persistencia en una base de datos en memoria (H2), JWT para la autenticación, y Swagger para la documentación de la API. A continuación, se proporcionan instrucciones detalladas sobre cómo probar y entender la solución.

## Requisitos

- Java 17 o superior
- Maven
- IDE compatible con Spring Boot 3.0 o superior (Eclipse, IntelliJ, etc.)
- Git
- Postman u otra herramienta similar para probar la API
- H2

## Estructura del Proyecto

```/
|-- src/
|   |-- main/
|   |   |-- java/
|   |   |   |-- com/
|   |   |       |-- latam/
|   |   |           |-- nisum/
|   |   |               |-- config/
|   |   |                   |-- SwaggerConfig.java
|   |   |               |-- dto/
|   |   |                   |-- UserRequestDTO.java
|   |   |                   |-- UserResponseDTO.java
|   |   |               |-- controller/
|   |   |               |   |-- UserController.java
|   |   |               |
|   |   |               |-- model/
|   |   |               |   |-- User.java
|   |   |               |   |-- Phone.java
|   |   |               |
|   |   |               |-- repository/
|   |   |               |   |-- UserRepository.java
|   |   |               |
|   |   |               |-- service/
|   |   |                   |-- UserService.java
|   |   |                      |-- impl/
|   |   |                         |-- UserServiceImpl.java
|   |   |               |-- util/
|   |   |               |   |-- JwtUtil.java
|   |   |               |


|   |   |
|   |   |-- resources/
|   |       |-- application.properties
|   |
|   |-- test/
|       |-- java/
|           |-- com/
|               |-- tuempresa/
|                   |-- usuario/
|                       |-- controller/
|                           |-- UserControllerTest.java
|                       |
|                       |-- service/
|                           |-- UserServiceTest.java
|
|-- pom.xml
|-- README.md

```

## Configuración del Proyecto

1. Clone el repositorio: git clone https://github.com/jesuslinares307/nisum
2. Abra el proyecto en su IDE preferido.
3. Ajuste la configuración de la base de datos en el archivo src/main/resources/application.properties.
Por default esta configurado un H2
4. Compile el proyecto utilizando Maven. (Se puede usar el siguiente comando: mvn clean install)

Please make sure to update tests as appropriate.

## Ejecución del Proyecto
1. Ejecute la aplicación desde su IDE o mediante el comando ./mvnw spring-boot:run en la línea de comandos.
2. La aplicación estará disponible en http://localhost:8080.
3. Tambien se podrá observar en http://localhost:8080/h2-console/ cuando se realice la ingesta de data desde postman

Los datos de accesos a la base de datos de H2, estan en el application.properties del proyecto,
se entiende son credenciales para pruebas y en ningun momento algo productivo. 

## Documentación de la API
La documentación de la API se realiza mediante Swagger y estará disponible en http://localhost:8080/swagger-ui/index.html#/

Si bien en Swagger se tiene toda la informacio del API, tambien se puede ejecutar en postman con un POST:
http://localhost:8080/api/v1/users/register

y un Body:
```
{
    "name": "prueba1",
    "email": "prueba1@test.com",
    "password": "Prueba1234",
    "phones": [
            {
            "number": "1234567",
            "cityCode": "1",
            "countryCode": "57"
            }
        ]
}
```
