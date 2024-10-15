FROM openjdk:21-jdk
WORKDIR /app
COPY target/insurance-service-0.0.1-SNAPSHOT.jar /app/insurance-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "insurance-service.jar"]
