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
COPY --from=build /app/target/insurance-service-0.0.1-SNAPSHOT.jar /app/insurance-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "insurance-service.jar"]
