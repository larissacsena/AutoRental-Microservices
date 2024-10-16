FROM openjdk:21-jdk
WORKDIR /app
COPY target/rental-service-0.0.1-SNAPSHOT.jar /app/rental-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "rental-service.jar"]
