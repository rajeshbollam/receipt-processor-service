# Dockerfile

## Build stage
#FROM eclipse-temurin:17 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Run stage
#FROM eclipse-temurin:17
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]

FROM eclipse-temurin:17
WORKDIR /app
COPY target/receipt-processor-0.0.1.jar /app/receipt-processor.jar
ENTRYPOINT ["java", "-jar", "receipt-processor.jar"]
