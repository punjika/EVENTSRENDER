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

ENV JAVA_OPTS=""
EXPOSE 8080

# Use PORT env var if provided by the platform; default 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Dserver.port=${PORT:-8080} -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-prod} -jar /app/app.jar"]
