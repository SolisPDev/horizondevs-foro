# API del Foro de HorizonDevs

## Descripción del Proyecto

Esta API REST, desarrollada en Java con Spring Boot 3, está diseñada para gestionar tópicos. Proporciona endpoints para crear, leer, actualizar y eliminar tópicos, así como para obtener una lista completa de los mismos. La API está protegida con autenticación JWT utilizando Spring Security.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot 3**: Framework para desarrollo de aplicaciones Java.
- **Spring Security**: Framework de seguridad para aplicaciones Java.
- **MySQL**: Base de datos relacional para almacenar los datos de los tópicos.
- **Maven**: Herramienta de construcción para gestionar las dependencias y el ciclo de vida del proyecto.
- **JWT**: Mecanismo de autenticación basado en tokens para asegurar la comunicación entre el cliente y el servidor.
- **Swagger UI**: Herramienta para generar documentación interactiva de la API.

## Estructura de la API

### Endpoints

- **POST /topico**:
    - Crea un nuevo tópico. Requiere autenticación.
    - Cuerpo: JSON con los campos `titulo`, `mensaje`, `autor` y `curso`.

- **GET /topico**:
    - Obtiene una lista de todos los tópicos. Requiere autenticación.
    - Respuesta: JSON con una lista de objetos, cada uno con los campos `id`, `titulo`, `mensaje`, `fechaCreacion`, `estado`, `autor` y `curso`.

- **GET /topico/{id}**:
    - Obtiene un tópico específico por su ID. Requiere autenticación.
    - Respuesta: JSON con los detalles del tópico.

- **PUT /topico/{id}**:
    - Actualiza un tópico existente. Requiere autenticación.
    - Cuerpo: JSON con los campos `titulo` y `mensaje` a actualizar.
    - Restricciones: No se permiten duplicados de título y mensaje.

- **DELETE /topico/{id}**:
    - Marca un tópico como deshabilitado (borrado lógico). Requiere autenticación.

## Documentación

La documentación detallada de la API está disponible en Swagger UI. Puedes acceder a ella en [Swagger UI Documentation](https://swagger.io/docs/).

> **Nota:** La URL de la documentación se generará automáticamente una vez que la aplicación esté en ejecución.

