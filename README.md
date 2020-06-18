# product-manager
Microservicio para el manejo de productos


En el archivo properties se debe colocar el usuario y el password de mysql

En la carpeta scripts/db se encuentra un sql para crear la base de datos y la entidad de productos.


se debe clonar el repositorio y ejecutar 'mvn clean compile install package' con el que instalaremos las dependencias y crearemos el jar.

Al ejecutar el jar la aplicacion tiene configurado el puerto 8090, este debe estar libre o puede cambiarse en el archivo de propiedades.

Para la documentacion de la API se uso swagger con una implementacion basica http://localhost:8090/swagger-ui.html si le cambian el puerto debe actualizarlo en el link.








