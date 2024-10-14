FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/insurance-service-0.0.1-SNAPSHOT.jar /app/insurance-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "insurance-service.jar"]
