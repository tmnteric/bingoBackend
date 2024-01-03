# Proyecto de Juego de Bingo para SofkaU (Backend)

En este proyecto, desarrollé el backend utilizando Spring Boot, aplicando una lógica de distribución que sigue las mejores prácticas. Inicialmente, creé las clases modelo o entidades, se crea la clase 'User', la cual almacena en la base de datos información esencial del usuario como nombre, correo y contraseña.

Adicionalmente, implementé la clase 'Tarjeton', que almacena listas para cada letra del bingo. Luego, en el repositorio 'UserRepository', implementé la validación para buscar al usuario por su correo, facilitando así el proceso de autenticación del usuario.

En el service, desarrollé el 'UserService', creando un conjunto de operaciones CRUD para diversas validaciones. Actualmente, solo estoy utilizando el método 'guardarUsuario', junto con el método 'iniciarSesion', que realiza una validación del correo y la contraseña.

También implementé el service 'TarjetonService', donde creé toda la lógica para generar el tarjetón del bingo, definiendo los parámetros para cada rango de números en cada letra.

Como complemento, desarrollé el service 'JugadorService', que actúa como un contador para rastrear cuántos jugadores se han autenticado en el sistema.

Finalmente, en el controlador 'UserController', generé una API para la creación de usuarios y la API de inicio de sesión '/login' con el 'RequestMapping' '/api/users'. En el controlador 'TarjetonController', creé la API '/generar' bajo '/api/tarjeton', y en el 'JugadorController', creé la API '/count' bajo el 'RequestMapping' '/api/players'.

## Enlaces Adicionales

- **Repositorio del Frontend:**
  - [https://github.com/tmnteric/bingoFrontend.git](enlace_al_repositorio_del_frontend)

- **Video Explicativo en YouTube:**
  - [https://youtu.be/wgOXN_txL-U](https://www.youtube.com/watch?v=wgOXN_txL-U&ab_channel=ericparra)
