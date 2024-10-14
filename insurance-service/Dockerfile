FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/seguro-service-0.0.1-SNAPSHOT.jar /app/seguro-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "seguro-service.jar"]
