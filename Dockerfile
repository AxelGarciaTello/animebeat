# Usar una imagen base con Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo JAR a la imagen
COPY target/animebeat-0.0.1-SNAPSHOT.jar app.jar

# Crear la carpeta uploads
RUN mkdir uploads

# Especificar el puerto en el que se ejecutará la app
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
