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
COPY --from=build /app/target/rental-service-0.0.1-SNAPSHOT.jar /app/rental-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "rental-service.jar"]
