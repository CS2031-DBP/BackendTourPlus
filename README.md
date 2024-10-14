# Portada

Título: TourPlus

¡Bienvenidos a TourPlus! En un mundo donde la planificación de viajes puede ser abrumadora y desorganizada, nuestra
plataforma se presenta como la solución integral que todos los viajeros estaban esperando. TourPlus es una aplicación
web y móvil intuitiva diseñada para facilitar la exploración, comparación y reserva de tours turísticos de manera
sencilla y eficiente.

Nombre del curso: CS 2031 Desarrollo Basado en Plataforma.

Integrantes: 
- Jhon Erick Chilo Gonzales
- Paris Lenard Herrera Torres
- Isaac Percy Gamero Del Aguila
- Michael Antonio Castillo Melchor

# Índice

#### 1. Introducción
1.1. Contexto
1.2. Objetivos del proyecto
   
#### 2. Identificación del problema o necesidad
2.1. Descripción del problema
2.2. Justificación
   
#### 3. Descripción de la solución
3.1. Funcionalidades Implementadas
3.2. Tecnologías Utilizadas
   
#### 4. Modelo de Entidades
#### 5. Testing y Manejo de Errores
#### 6. Medidas de Seguridad Implementadas
#### 7. Eventos y Asincronía
#### 8. GitHub
#### 9. Conclusión
#### 10. Apéndices

# Introducción

Contexto: 
La falta de una plataforma consolidada que ofrezca exploración, comparación y reserva de tours de manera integral puede llevar a una experiencia de usuario fragmentada y frustrante. Los usuarios a menudo deben navegar por múltiples sitios y aplicaciones para obtener la información necesaria, lo que puede ser ineficiente y tedioso. Abordar esta problemática mediante el desarrollo de TourPlus permitirá a los usuarios acceder a una solución “todo en uno”, mejorando la facilidad de planificación y reserva de sus viajes. Además, al incorporar recomendaciones personalizadas y opciones de pago seguras, se aumentará la satisfacción del usuario y se fomentará la lealtad a la plataforma.

Objetivos del Proyecto:
- Desarrollar una plataforma web y móvil intuitiva que permita a los usuarios explorar y comparar una amplia gama de tours turísticos en diversas localidades de manera fácil y rápida.
- Implementar un sistema de recomendaciones personalizadas basado en las preferencias y el historial de los usuarios para ofrecer sugerencias relevantes y mejorar la experiencia de búsqueda.
- Implementar un sistema de pago en línea seguro que permita a los usuarios realizar reservas y pagos de tours de forma segura.
- Incorporar un sistema de reseñas y comparaciones que permita a los usuarios leer opiniones de otros viajeros y comparar diferentes opciones de tours para tomar decisiones informadas.
- Asegurar la disponibilidad en tiempo real de los tours mediante la integración de APIs, proporcionando a los usuarios información actualizada y precisa sobre la disponibilidad de las ofertas.

# Identificación del Problema o Necesidad

#### Descripción del Problema:

Los viajeros enfrentan dificultades al intentar planificar sus tours debido a la falta de plataformas que integren funcionalidades como búsqueda, comparaciones y pagos seguros en un solo lugar. Esto resulta en problemas al momento de viajar y hacer tours.

#### Justificación:
Actualmente, los viajeros a menudo enfrentan dificultades al intentar encontrar y reservar tours debido a la falta de plataformas que integren todas las funcionalidades necesarias en un solo lugar. TourPlus ofrece una solución completa que combina búsqueda, recomendaciones, pagos seguros y comparaciones en una única plataforma, mejorando la experiencia del usuario y facilitando la planificación de viajes.

## Descripción de la Solución

### Funcionalidades Clave:

- **Barra de Búsqueda y Recomendaciones:** Encuentra tours por destino y muestra recomendaciones principales.
- **Acceso a Ubicación Actual:** Solicita permiso para acceder a la ubicación del usuario y ofrecer recomendaciones cercanas.
- **Listado de Tours Disponibles:** Muestra opciones de tours disponibles basados en la ubicación ingresada.
- **Filtros de Búsqueda:** Filtra tours por categorías como aventura o cultura.
- **Detalles del Tour:** Muestra imágenes, descripción, horarios y precios del tour seleccionado.
- **Filtrado por Puntuación:** Permite ordenar los tours según su calificación.
- **Lista de Favoritos:** Los usuarios pueden guardar tours en una lista para acceder a ellos más tarde.
- **Reserva de Tours:** Realiza reservas seleccionando fechas, número de personas y completando el pago.
- **Gestión de Perfiles de Usuario:** Permite registrar, iniciar sesión y gestionar información personal y reservas.
- **Comentarios y Valoraciones:** Los usuarios pueden dejar opiniones y puntuaciones sobre los tours.

### Tecnologías Utilizadas:

- **Backend:** Spring Boot, Java
- **APIs Externas:** Google Maps API

## Modelo de Entidades

- **Usuario:** Almacena la información del cliente, como su perfil y preferencias.
- **Tour:** Contiene detalles de los tours, como descripciones, imágenes, precios y categorías.
- **Reserva:** Gestiona las reservas de los tours, incluyendo fecha, personas y estado de pago.
- **Reseña:** Permite a los usuarios dejar valoraciones y comentarios sobre los tours.

## Testing y Manejo de Errores

### Tipos de Pruebas Realizadas:
### **Pruebas Unitarias:** Aseguran que cada componente funcione de manera aislada.
   - **UserTest:** Verifica la correcta creación de un objeto User y la manipulación de sus atributos.
   - **RideTest:** Asegura que los métodos de cálculo de tarifas en la clase Ride funcionen como se espera.
   - **ReviewTest:** Comprueba la validación de comentarios y calificaciones al crear un Review.
   - **PassengerTest:** Verifica la lógica de añadir y eliminar coordenadas en la clase Passenger.
   - **DriverTest:** Asegura que los métodos de asignación de viajes en la clase Driver operen correctamente.
   - **AuthServiceTest:** Comprueba la autenticación de usuarios y el manejo de contraseñas.
### **Pruebas de Integración:** Verifican que los módulos de la aplicación trabajen en conjunto.
   - **UserRepositoryTest:** Verifica la persistencia y recuperación de usuarios en la base de datos.
   - **RideRepositoryTest:** Asegura que los viajes se guarden correctamente y se recuperen según criterios específicos.
   - **ReviewRepositoryTest:** Comprueba la creación y recuperación de reseñas de viajes en la base de datos.
   - **UserServiceTest:** Verifica la lógica de negocio al interactuar con el UserRepository.
   - **RideServiceTest:** Asegura que las tarifas se calculen y los viajes se asignen correctamente a los pasajeros.
   - **ApplicationContextTest:** Verifica que todos los componentes del contexto de la aplicación se carguen correctamente.
### **Pruebas de Aceptación:** Validan los procesos de la aplicación.
   - **UserAcceptanceTest:** Valida el registro, inicio de sesión y obtención de un usuario a través de la API.
   - **RideAcceptanceTest:** Comprueba el flujo completo de creación y aceptación de un viaje.
   - **ReviewAcceptanceTest:** Valida la creación y visualización de reseñas de un viaje a través de la API.
   - **PaymentAcceptanceTest:** Asegura que el proceso de pago funcione correctamente desde la solicitud hasta la confirmación.
   - **SearchAcceptanceTest:** Verifica que los usuarios puedan buscar y filtrar viajes según diferentes criterios.
   - **AdminAcceptanceTest:** Comprueba las funcionalidades administrativas, como la gestión de usuarios y viajes, a través de la API.
### **Pruebas de Sistema:** Validan que la aplicación completa funcione correctamente.

## Resultados:
Los resultados de las pruebas fueron positivos, aunque se identificaron algunos errores y fallos que fueron corregidos. Los principales problemas encontrados incluyeron:
- Errores de validación en la creación de usuarios que permitían datos incorrectos.
- Fallos en la recuperación de usuarios que no manejaban adecuadamente los casos en que el usuario no existía.
- Problemas de autorización que permitían accesos no deseados a ciertos recursos.
Todas estas fallas fueron abordadas y corregidas, mejorando la robustez y seguridad de la aplicación.

### Manejo de Errores:
Se implementaron excepciones globales para capturar y manejar los errores durante la ejecución de la aplicación.

## Medidas de Seguridad Implementadas:

### Uso de JWT para Autenticación
- **JWT (JSON Web Token)** es un estándar seguro para intercambiar información entre un cliente y un servidor de manera compacta y auto-contenida. Esta clase genera, verifica y valida tokens JWT, lo cual permite que los usuarios autenticados realicen solicitudes a la aplicación.

### Cifrado del Token JWT:
- Se utiliza el algoritmo **HMAC256** para firmar los tokens JWT. Este algoritmo simétrico asegura que el token no puede ser alterado sin la clave secreta (almacenada en la propiedad jwt.secret).
La clave secreta se inyecta en el servicio usando la anotación @Value("${jwt.secret}"), lo que garantiza que no esté expuesta directamente en el código fuente.

### Fecha de Expiración de Tokens:
- Los tokens generados incluyen una fecha de expiración (withExpiresAt). En este caso, el token es válido por 10 horas. Esto previene el uso de tokens viejos o robados después de que hayan caducado

## GitHub

Se asignaron tareas a cada miembro del equipo utilizando el sistema de issues de GitHub.

## Conclusión

**TourPlus** simplifica la búsqueda y selección de tours, ofreciendo recomendaciones personalizadas y pagos seguros. El proyecto logró pasar todas las pruebas, cumpliendo con las funcionalidades esperadas.

### Trabajo Futuro

- Integración de más APIs de tours internacionales.
- Mejora en el sistema de recomendaciones utilizando machine learning.

## Licencia

Este proyecto está distribuido bajo la licencia IntelliJ IDEA.








