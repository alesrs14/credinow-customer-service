# credinow-customer-service
Servicio de adición y autenticación de usuarios

## Descripción
Este es un servicio Spring Boot que proporciona funcionalidades para la gestión de clientes, incluyendo:
- Registro de nuevos clientes
- Autenticación de usuarios
- Operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para clientes
- Seguridad con Spring Security
- Base de datos en memoria H2 para desarrollo

## Requisitos
- Java 17 o superior
- Maven 3.6 o superior

## Compilación

### Compilar el proyecto
```bash
mvn clean compile
```

### Ejecutar tests
```bash
mvn test
```

### Generar el archivo JAR ejecutable
```bash
mvn clean package
```

### Ejecutar la aplicación
```bash
mvn spring-boot:run
```

O ejecutar el JAR generado:
```bash
java -jar target/customer-service-0.0.1-SNAPSHOT.jar
```

## Uso

### Endpoints de la API

La aplicación se ejecuta en `http://localhost:8080`

#### Clientes
- `GET /api/customers` - Obtener todos los clientes
- `GET /api/customers/{id}` - Obtener un cliente por ID
- `POST /api/customers` - Crear un nuevo cliente
- `PUT /api/customers/{id}` - Actualizar un cliente
- `DELETE /api/customers/{id}` - Eliminar un cliente
- `POST /api/customers/authenticate` - Autenticar un cliente

#### Base de datos H2 Console
- `http://localhost:8080/h2-console`
- URL JDBC: `jdbc:h2:mem:testdb`
- Usuario: `sa`
- Contraseña: `password`

### Ejemplo de uso

#### Crear un cliente
```bash
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Juan",
    "lastName": "Pérez",
    "email": "juan@example.com",
    "password": "password123"
  }'
```

#### Autenticar un cliente
```bash
curl -X POST http://localhost:8080/api/customers/authenticate \
  -H "Content-Type: application/json" \
  -d '{
    "email": "juan@example.com",
    "password": "password123"
  }'
```

## Datos de prueba
La aplicación incluye datos de prueba predefinidos:
- Usuario: juan.perez@example.com / password: password123
- Usuario: maria.garcia@example.com / password: password123
