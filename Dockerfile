# Dockerfile

FROM eclipse-temurin:17
WORKDIR /app
COPY target/receipt-processor-0.0.1.jar /app/receipt-processor.jar
ENTRYPOINT ["java", "-jar", "receipt-processor.jar"]
