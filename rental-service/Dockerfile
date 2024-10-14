FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/aluguel-service-0.0.1-SNAPSHOT.jar /app/aluguel-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "aluguel-service.jar"]
