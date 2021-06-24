# pruebaAsd
- Sistema que permite realizar el manejo de activos Fijos (bienes Materiales) de una empesa, permite crear, actualizar y consultar la lista de activos y sus diferentes caracteristicas. El sistema se compone de dos frentes de desarrollo, back End, Front end y se incluye base de datos H2 data base.

# experiencia de Usuraio
- El documento de experiencia de usuario, muestra el detalle de los componentes expuestos para la navegación y experiencia del usuario final.
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
### Para ejecutar las pruebas de los servicios
- Postman
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
- Esto genera una carpeta llamada dist dentro de la ruta pruebaAsd/activosFijosFrontEnd/activosFijos/ ingresamos a esta ruta por medio de la linea de comando y jecuntamos el siguiente comando
```
jar -cvf activoFijo.war *
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
## Importar pruebas Postman
- Descargue el archivo testActivosFijos.postman_collection.json
- Inicie el aplicativo postman
- Seleccione la opción import
- Seleccione la opción file
- Busque y seleccione el archivo testActivosFijos.postman_collection.json
## Model DB
![alt text](https://github.com/Serya32/pruebaAsd/blob/main/modelDB.PNG?raw=true)
