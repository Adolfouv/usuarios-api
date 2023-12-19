#API REST de Gestión de Usuarios

Esta API REST es un servicio backend diseñado para gestionar el registro y la administración de usuarios. Permite crear, actualizar, eliminar y recuperar información de usuarios, así como manejar la autenticación y el control de acceso.

La API es ideal para integrarse en aplicaciones que requieren la gestión de usuarios, con soporte para operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre los datos de los usuarios. Además, implementa autenticación JWT (Json Web Tokens) para asegurar la comunicación y el acceso a los recursos.

Características
Registro de Usuarios: Permite a los nuevos usuarios registrarse, almacenando sus datos de forma segura.
Autenticación: Autentica a los usuarios y proporciona tokens de acceso para interactuar con la API.
Gestión de Usuarios: Administra la información de los usuarios, permitiendo actualizar y eliminar registros.
Seguridad: Utiliza estándares de seguridad para proteger la información de los usuarios y las transacciones.
Esta API está construida utilizando Spring Boot, lo que facilita su despliegue y escalabilidad en distintos entornos, y proporciona una estructura robusta para el manejo de las peticiones y la lógica de negocio.

Para poder levantar el proyecto necesitaremos:

- Un IDE que sea capaz de levantar un servidor SpringBoot. (En este caso utilizaremos IntelliJ Ultimate IDEA)
- Setear la estructura del proyecto con SDK11
- Poseer una herramienta de testing como POSTMAN


La base de datos se creará una vez levantemos el proyecto SpringBoot, por lo que no se requiere un Script adicional

A continuación demostraremos paso a paso como se puede levantar esta API Rest en un ordenador desde 0.

1) Clonar el proyecto
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/d56dc700-da38-421e-a9b3-be9c6d711d44)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/7adc0c8c-88c9-4b64-944b-19da87fd0226)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/2e35a493-0de0-4f55-ba02-12baf403c5e5)


2) Ahora abrimos el repositorio en un IDE, en este caso utilizaremos IntelliJ Ultimate IDEA
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/9a5b363b-1662-44a3-82b2-4944f077e9ad)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/fa3839dc-c699-4c73-980b-0565b5d8e8ca)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/bf2b9282-b8b9-45dc-910c-e34db40da9c4)

3) Especificar la version de JDK y language level que utiliza el proyecto (JDK 11)
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/88867c23-ffae-46e9-9245-175d5b23fed6)

4) Ejecutar comando mvn clean install
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/c66dc1c5-e544-4238-a0b9-c3720e12650a)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/2739849f-dce6-4d5d-8be2-6ba6512d356d)

5) Levantamos el servidor springboot local
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/1b811df3-fd1a-457e-9d47-b1f69c643018)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/2d255f1d-728e-4ad7-bc9a-72f2b8fc00da)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/e5b424a9-8839-4190-8ffa-1b425206b998)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/a49070a8-d999-41e0-9b09-062554031fd2)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/4ffb9889-883c-4c67-a741-8e3976ce45b2)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/451f48fc-b84e-4c66-9c8d-72d82d743abd)


6) Compilamos el proyecto
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/68f96dfe-acb8-4b49-9476-0a82cd38bb23)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/7216bb9e-67bc-4741-ba12-50430c7aac3f)


Una vez levantado el proyecto podremos probarlo con una coleccion POSTMAN que está preparada para que el usuario interactúe directamente con el puerto 8080 (en caso de levantar el proyecto en otro puerto, por favor ajustar el puerto en cada endpoint de cada http request)

[NTTDATA Gestor de Usuarios.postman_collection.json](https://github.com/Adolfouv/usuarios-api/files/13709757/NTTDATA.Gestor.de.Usuarios.postman_collection.json)

1) Al importar correctamente el archivo JSON dentro de postman podrás visualizar 5 endpoints
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/890416d6-d4ab-49ed-88f7-298b2021ab42)

2) El primero "Buscar Todos los Usuarios" nos devolverá un ArrayList[] vacío dado que no hemos agregado ningun usuario aún a la base de datos de memoria
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/d8bd6fb4-8227-4f68-9bf0-7c6c9fb39f6d)

3) El segundo "Agregar un Usuario" agregará un usuario dentro de ese ArrayList[] anterior. Y devolverá una respuesta donde también se encuentra un TOKEN para futuras funcionalidades de la aplicación.
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/d1541b85-ee90-463e-a85a-1c8f73c5f05c)

Si consultamos nuevamente al endpoint anterior ya podremos visualizar un usuario ingresado:
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/63c738c1-880a-45b1-9f33-dc8d4a57ef57)

4) El tercer endpoint "Borrar un Usuario" sirve para setear el campo "Activo" del usuario de True a --> False
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/b88fcf3a-6d4c-4e59-8387-e3a1a2e9a36f)

Fijate que cuando creamos un usuario, éste se crea con el campo "Activo" seteado en True por defecto;
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/8b4d8a61-5877-409c-9d0a-4a7f5183b0e6)

Ahora vamos a tomar el ID del usuario (en este caso el id 1) y lo utilizaremos en nuestro endpoint para hacer la eliminación lógica (y dejarlo inactivo)
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/7c1cc6d4-83c5-4177-ad49-1a2bf5328c32)
(nótese que debemos informar el id en el endpoint dado que es un pathvariable)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/6ed5c753-9e45-4ce7-8e0a-86d877910e09)

Ahora consultemos nuevamente el endpoint que trae todos los usuarios para visualizar el estado del usuario;
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/763614bb-9be2-4c7a-884f-d63e8a276b1e)

5) Vamos a crear otro usuario:
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/9d70c1cb-16c7-4b3f-8b0f-612ed336d94e)

(Se ha creado con el id 2)

El cuarto endpoint "Actualizar un Usuario" sirve para actualizar el usuario que fue agregado, en este caso modificaremos el "nombre" y el "correo"
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/77801b99-9774-4641-b9fa-86213d786708)
(nótese que debemos informar el id en el endpoint dado que es un pathvariable)

![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/1f66753a-e6ad-477e-8c13-5ea9f20751fa)

6) Tenemos un quinto endpoint "Consultar por ID usuario" para consultar por un usuario en particular
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/cdd9120f-1d9b-43fe-b235-273f91aeb303)
(nótese que los datos "nombre" y el "correo" fueron modificados exitosamente)

Las pruebas Unitarias de este proyecto fueron realizadas;
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/89820899-2b59-4b96-b579-8afcb2b202a8)


La expresión regular para la contraseña que se va crear con el usuario quedó paramétrica en application.properties
![image](https://github.com/Adolfouv/usuarios-api/assets/69990720/cb925303-67c6-4fa3-85d3-111fbbb048c3)


