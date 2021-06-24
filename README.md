# pruebaAsd
- Sistema que permite realizar el manejo de activos Fijos (bienes Materiales) de una empesa, permite crear, actualizar y consultar la lista de activos y sus diferentes caracteristicas. El sistema se compone de dos frentes de desarrollo, back End, Front end y se incluye base de datos H2 data base.
# Tecnologias implementadas
### Back end
- Spring Boot
- H2 dataBase
### Front end
- Angular
- Boostrap
- AngularMaterial
## Prerequisitos
Para correr/ejecutar este proyecto, necesita tener instalado y configurado:
### Para correr BackEnd:
- Git
- JDK8
- Maven
- Postman o Insomnia
### Para correr FrontEnd
- Git
- Node y Npm
- Angular Cli 10.2.0
- Un IDE para poder editar el código. En este caso se utilizo Visual Studio Code, pero se puede utilizar cualquier otro.
## Despliegue Local

### Back End
- Abrir la consola Git Bash en la ruta donde quiere descargar el proyecto, clonar el repositorio con el comando:
```
git clone https://github.com/Serya32/pruebaAsd.git
```
- Ingrese al proyecto con el comando
 ```
 cd pruebaAsd/activosFijosBackEnd/
```
- Ejecutar el siguiente comando para ejeutar el proyecto
 ```
 mvn clean package
```
- Para ejecutar el programa ingrese a la carpeta /target
```
 cd target/
```
- PosteriorMente ejecutar el comando
```
 java -jar activosFijos-0.0.1-SNAPSHOT.jar
```
### Front End War
- Ya con el proyecto clonado en el primer paso del backEnd, ingrese al proyecto con el comando:
```
 cd pruebaAsd/activosFijosFrontEnd/activosFijos/
``` 
- Instale las librerias para correr el proyecto con el comando
```
 npm install
``` 
- Posteriormente para ejecutar el comando:
```
 ng build --configuration production --base-href=/activos-fijos/ --outputHashing=all
``` 
### Front End VSCode
- Si desea ejecutarlo localmente, con el Ide (visual estudio code), abra el proyecto front end en la ruta
```
 cd pruebaAsd/activosFijosFrontEnd/activosFijos/
``` 
- Ejecute el comando
```
 ng s
``` 
- Ingrese a la siguiente ruta desde el navegador de su preferencia
```
 http://127.0.0.1:4200/
``` 

![alt text](https://github.com/Serya32/pruebaAsd/main/Captura.png?raw=true)
