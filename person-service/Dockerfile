# Etapa de build
FROM maven:latest AS build
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests
RUN ls -la /app/target

# Etapa de runtime
FROM openjdk:21-jdk
WORKDIR /app
COPY --from=build /app/target/person-service-0.0.1-SNAPSHOT.jar /app/person-service.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "person-service.jar"]