# Multi-stage Dockerfile for the demo Spring Boot app
# Build stage
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /workspace

# Copy only what we need for a Maven build to leverage layer caching
COPY pom.xml ./
COPY src ./src

# Build the application (skip tests for faster image builds)
RUN mvn -DskipTests package

# Runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /workspace/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Copy a small start wrapper that handles different jar locations and prints diagnostics
COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh

ENV JAVA_OPTS=""
EXPOSE 8080

# Use the wrapper so the container can start even if different start commands were used elsewhere
ENTRYPOINT ["/app/start.sh"]
