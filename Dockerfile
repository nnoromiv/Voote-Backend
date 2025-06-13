# ---------- Stage 1: Build the app ----------
FROM gradle:8.5-jdk17 AS build

# Copy everything to the build container
COPY --chown=gradle:gradle . /home/gradle/project

WORKDIR /home/gradle/project

# Build the application (bootJar)
RUN gradle bootJar --no-daemon

# ---------- Stage 2: Run the app ----------
FROM openjdk:17-jdk-slim

# Copy the built jar from the previous stage
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

# Set port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
