![imagen proyecto](https://github.com/sandraEstlo/pfc_letras/blob/main/images/banner.png)

# 📚 Aplicación Web de Biblioteca

Este proyecto consiste en el desarrollo de una **aplicación web para la gestión de una biblioteca**. Los usuarios pueden buscar libros, realizar reservas y renovar préstamos. La aplicación está desarrollada en **Java** usando **Spring Boot** para el backend, **Thymeleaf** para el frontend y **MongoDB** para la base de datos.

## 🎯 Objetivos del Proyecto
1. 📖 Facilitar la gestión de una biblioteca digital mediante un sistema web.
2. 🔍 Permitir a los usuarios realizar búsquedas en el catálogo de libros.
3. 🗓️ Habilitar funciones de reserva y renovación de préstamos de manera eficiente.
4. 🔐 Aplicar medidas de seguridad básicas con **Spring Security**.
5. 🛠️ Mantener una arquitectura clara y escalable utilizando el patrón **MVC**.

## Tecnologías Utilizadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) 
![Spring Data](https://img.shields.io/badge/Spring%20Data-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![Bulma](https://img.shields.io/badge/Bulma-00D1B2?style=for-the-badge&logo=bulma&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

> #### 💡 Proyecto Anterior
> Este proyecto esta basado en una aplicación de escritorio (C#), realizado durante el segundo trimestre del módulo de **Desarrollo de Interfaces** en el **Grado Superior de Aplicaciones Multiplataforma**.
> 
> 📂 Puedes ver el repositorio del proyecto anterior aquí: [Repositorio Proyecto Anterior](https://github.com/sandraEstlo/gestion_biblioteca_admin)

## Desarrollo de la aplicación

### Interfaz del usuario
#### Usuario anónimo
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/01.png" alt="general">
</p>
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/login.png" alt="Login">
</p>
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/Registro.png" alt="Registro">
</p>
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/filtros.png" alt="Registro">
</p>
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/detalle.png" alt="Registro">
</p>
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/paginacion.png" alt="Registro">
</p>


#### Usuario autentificado
Una vez se inicia sesión, si el usuario dispone del Rol de ‘Usuario’, se le redirigirá a la página principal con ciertos cambios en los componentes, permitiendo además las opciones de búsqueda y filtrado permitidas a los usuarios anónimos, tramitar reservas o renovar préstamos.

<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/principal.png" alt="Registro">
</p>
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/sesion.png" alt="Registro">
</p>
<p align="center">
  <img src="https://github.com/sandraEstlo/pfc_letras/blob/main/images/reservas.png" alt="Registro">
</p>




