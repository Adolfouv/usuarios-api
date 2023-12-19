[NTTDATA Gestor de Usuarios.postman_collection.json](https://github.com/Adolfouv/usuarios-api/files/13709757/NTTDATA.Gestor.de.Usuarios.postman_collection.json)#API REST de Gestión de Usuarios

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

[Uploading NTTDATA G{
	"info": {
		"_postman_id": "134a8aa6-378e-40cc-b393-57f35c1b5713",
		"name": "NTTDATA Gestor de Usuarios",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "16895339"
	},
	"item": [
		{
			"name": "Buscar Todos los Usuarios",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/usuarios/consultarTodosLosUsuarios",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"consultarTodosLosUsuarios"
					]
				}
			},
			"response": []
		},
		{
			"name": "Agregar un Usuario",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"nombre\": \"Adolfo Ulloa\",\r\n    \"correo\": \"fito8829@example.com\",\r\n    \"contraseña\": \"p2assWORD!\",\r\n    \"telefonos\": [\r\n        {\r\n            \"numero\": \"55553222\",\r\n            \"codigoCiudad\": \"7\",\r\n            \"codigoPais\": \"59\"\r\n        }\r\n    ]\r\n}\r\n",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/usuarios/insertarUsuario",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"insertarUsuario"
					]
				}
			},
			"response": []
		},
		{
			"name": "Borrar un Usuario",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/usuarios/eliminarUsuario/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"eliminarUsuario",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Consultar por ID usuario",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"nombre\": \"Juan Perez\",\r\n    \"correo\": \"juanperez@example.com\",\r\n    \"contraseña\": \"Password123!\",\r\n    \"telefonos\": [\r\n        {\r\n            \"numero\": \"123456789\",\r\n            \"codigoCiudad\": \"1\",\r\n            \"codigoPais\": \"57\"\r\n        }\r\n    ]\r\n}\r\n",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/usuarios/consultarUsuario/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"consultarUsuario",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Actualizar un Usuario",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n    \"nombre\": \"Adolfo Ulloa2\",\r\n    \"correo\": \"fito818@example.com\",\r\n    \"contraseña\": \"p2assWORD!\",\r\n    \"telefonos\": [\r\n        {\r\n            \"numero\": \"11\",\r\n            \"codigoCiudad\": \"7\",\r\n            \"codigoPais\": \"59\"\r\n        }\r\n    ]\r\n}\r\n",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/usuarios/actualizarUsuario/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"usuarios",
						"actualizarUsuario",
						"1"
					]
				}
			},
			"response": []
		}
	]
}estor de Usuarios.postman_collection.json…]()

