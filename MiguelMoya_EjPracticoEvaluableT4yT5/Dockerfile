# Utilizar una imagen base de OpenJDK
FROM openjdk:17
WORKDIR /app

# Copiar el archivo JAR generado por Maven
COPY target/MiguelMoya_Reto4-AD_Hoteles.jar app.jar


# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
