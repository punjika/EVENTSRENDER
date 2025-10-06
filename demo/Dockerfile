# Multi-stage Dockerfile for the demo Spring Boot app
# Build stage
FROM maven:3.9.4-eclipse-temurin-17 AS builder
# Build in /workspace and support being built from repo root: copy demo sources under /workspace/demo
WORKDIR /workspace

# Copy the demo module from the repo root into the builder image
COPY demo/pom.xml demo/pom.xml
COPY demo/src demo/src

# Build the demo module using the image's mvn (avoid using the wrapper inside the container)
RUN mvn -f demo/pom.xml -DskipTests package

# Runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /workspace/demo/target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Copy a small start wrapper that handles different jar locations and prints diagnostics
COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh

ENV JAVA_OPTS=""
EXPOSE 8080

# Use the wrapper so the container can start even if different start commands were used elsewhere
ENTRYPOINT ["/app/start.sh"]
