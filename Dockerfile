# Use a lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Optional: Set environment variables
ENV JAVA_OPTS=""

# Create a folder for the app
WORKDIR /app

# Copy the compiled jar file into the container
COPY build/libs/*.jar app.jar

# Expose port (8080 is default for Spring Boot)
EXPOSE 8080

# Run the app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
