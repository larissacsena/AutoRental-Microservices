FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/rental-service-0.0.1-SNAPSHOT.jar /app/rental-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "rental-service.jar"]
