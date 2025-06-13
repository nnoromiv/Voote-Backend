# -------- Stage 1: Build with Java 21 + Gradle --------
FROM eclipse-temurin:21-jdk as builder

# Install Gradle manually
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://services.gradle.org/distributions/gradle-8.5-bin.zip && \
    unzip gradle-8.5-bin.zip -d /opt && \
    ln -s /opt/gradle-8.5/bin/gradle /usr/bin/gradle

# Set work directory
WORKDIR /app

# Copy project files
COPY . .

# Build the app
RUN gradle bootJar --no-daemon

# -------- Stage 2: Run with Java 21 --------
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
