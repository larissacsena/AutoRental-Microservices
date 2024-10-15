FROM openjdk:21-jdk
WORKDIR /app
COPY target/rentalModel-service-0.0.1-SNAPSHOT.jar /app/rentalModel-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "rentalModel-service.jar"]
