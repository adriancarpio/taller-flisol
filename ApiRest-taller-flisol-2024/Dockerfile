FROM maven:3.9.6 AS build 
# Usa la imagen oficial de Maven version 3.9.6 como la base para la etapa de construccion. AS build nombra esta etapa como build.

RUN mkdir /construir 
# RUN mkdir /construir: Crea un directorio llamado /construir dentro del contenedor.

WORKDIR /construir 
#Establece el directorio de trabajo actual a /construir. Todos los comandos posteriores se ejecutaran desde este directorio.

COPY . /construir
#Copia todo el contenido del directorio actual en tu maquina host al directorio /construir en el contenedor.

RUN mvn clean package install
#Ejecuta el comando de Maven para limpiar, empaquetar e instalar la aplicacion. clean elimina los archivos generados en compilaciones 
#anteriores, package empaqueta el proyecto en un archivo JAR, e install instala el paquete en el repositorio local del contenedor.

FROM openjdk:17
#Usa la imagen oficial de OpenJDK version 17 como base para la ejecucion de la aplicacion.

RUN mkdir /app
#Crea un directorio llamado /app dentro del contenedor.

WORKDIR /app
#Establece el directorio de trabajo actual a /app. Todos los comandos posteriores se ejecutaran desde este directorio.

COPY --from=build /construir/target/com.taller.flisol-1.0.jar /app/com.taller.flisol-1.0.jar
#Copia el archivo JAR generado en la etapa de construccion (build) desde /construir/target/com.taller.flisol-1.0.jar al directorio /app en la nueva imagen.

ENV DEFAULT_OPTIONS="-Duser.timezone=America/Guayaquil -Djava.net.preferIPv4Stack=true -Djava.security.egd=file:/dev/./urandom"
#Define variables de entorno. DEFAULT_OPTIONS configura la zona horaria, prefiere IPv4 sobre IPv6 y optimiza la generacion de numeros aleatorios.

ENV JAVA_OPTS="-Xms512m -Xmx896m"
#Define la variable de entorno JAVA_OPTS para establecer los parametros de memoria minima y maxima para la JVM (512MB y 896MB respectivamente).

ENTRYPOINT java ${DEFAULT_OPTIONS} ${JAVA_OPTS} -jar /app/com.taller.flisol-1.0.jar
#Establece el comando de entrada que se ejecutara cuando el contenedor se inicie. Aqui se ejecuta la aplicacion Java con las opciones definidas en las variables de entorno