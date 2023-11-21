# Laboratorio 2 Taller de Base de Datos

# Integrantes: 
* Enzo Gulppi
* Alexandra Navarro
* Marcelo Godoy
* Javiera Vergara

# Descripción del proyecto:
La entrega de laboratorio consiste en realizar una web en base a la descripción del proyecto entregado (Emergencia) con distintas funcionalidades según lo proyectado en dicho enunciado. Para esta entrega, se utiliza muchoas funcionalidades y apliaciones de codigo empleados en la primera entrega del laboratorio 1, pero la gran diferencia en este caso es emplear la extension de POSGIS para postgreSQL, cuya extension sirve para realizar consultas a la base de datos geoespacial.

El backend es una REST API hecha en Java springboot con sql2o más un Frontend para las vistas utilizando Vue.js y Nuxt.

# Descripción del repositorio:
El entregable se encuentra en este repositorio (link) y esta separado en 3 carpetas correspondiente a cada proyecto individual:
1. Frontend
1. Backend
1. Base de datos

# Requisitos para ejecutar el proyecto:
Para poder ejecutar el proyecto de forma completa, debemos contar con las siguientes herramientas:
- PostgreSQL versión 12
- Spring Boot maven 2.7.10.
- Vue js 2.x.
- JDK Java 11
- Node js versión +18
- Npm +9 (Viene por defecto con npm
- Postman versión +9 (Opcional)
- IDE VS CODE (Recomendado para Frontend)
- IDE Intellinj Idea Ultimate (Recomendado para Backend)

# Instrucciones para la instalación:
Clonar repositorio, para eso, abrir terminal de su sistema operativo.

Instalar PostgreSQL 12 y PGAdmin 4: Para ello, se puede instalar un pack en conjunto, se debe seleccionar la versión deseada para el Sistema Operativo deseado y seguir las instrucciones de instalación. Durante la instalación es necesario configurar un username y un password para utilizar con PostgreSQL. Estos serán luego necesarios para la creación de la Base de Datos junto con sus tablas.

Instalar IntelliJ IDEA Ultimate: Ingresar al sitio web oficial de IntelliJ IDEA y seleccionar el instalador dependiendo del Sistema Operativo en uso.

# Instalación del Backend:
Una vez instalado Intellij Idea, abrir el proyecto, una vez seleccionado el proyecto, esperamos que se configuren los plugins necesarios y si fuera el caso, que se instalen.

# Instalación Base de Datos:
Se debe crear una base de datos y esta se debe configurar en "Application.properties" ubicada eb la carpeta "Resourses" de la siguiente manera:
- server.port=8080
- db.url=jdbc:postgresql://localhost:5432/<NOMBRE_DATABASE>
- db.username=<USUARIO>
- db.password=<CONTRASEÑA>

# Instalación de Frontend:
Instalar la version mas reciente y estable de Node JS del siguiente sitio web:  https://nodejs.org/en  y seguir los pasos de instalación.
Abrir con VS CODE el proyecto de frontend, de forma similar como se abre el proyecto de backend.
Abrir la terminar en VS CODE y escribir los siguientes comandos:
- npm i vue
- npm install
- npm i nuxt
- npm i axios
- npm i leaflet vue2-leaflet

# Instrucciones de uso
1. En PgAdmin, seleccionar la opción "Query tool" y copiar la primera parte del script create.sql para solo crear las tablas.
2. Abrir la opción Query tool nuevamente, pero dentro de [database] (La Base de Datos que se crea en el paso 1) y copiar el resto de dbCreate.
3. Copiar todo el contenido de import.sql y ejecutarlo dentro de Query tool, posteriormente, deberá abrir dos Query Tool adicionales, donde copiará y ejecutará contenido de los archivos .sql en cada Query Tool.
4. Utilizando IntelliJ IDEA Ultimate, asegurarse de que se detecte correctamente Spring Boot y Maven. Ejecutar la aplicación haciendo click en la opción "Run" dentro de IntelliJ IDEA.
5. Dentro de la carpeta Frontend, abrir una consola / terminal. Ejecutar el siguiente comando: " npm run dev ".
Con esto ya tenemos levantado FrontEnd y Backend, por lo que podemos comenzar a utilizar la aplicación
