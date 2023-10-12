FROM openjdk:17-jdk-slim-buster


WORKDIR /app/

COPY target/digital-library-backend.jar /app

EXPOSE 8080

ENTRYPOINT ["java","-jar","digital-library-backend.jar"]