
# Use a lightweight OpenJDK base image
FROM openjdk:21-jdk-slim AS build

# Install Maven in the build stage
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set the working directory for the build
WORKDIR /build

# Copy the Maven project files to the container
COPY pom.xml ./
COPY src ./src

# Build the project using Maven
RUN mvn clean package -DskipTests

RUN mvn dependency:go-offline

# Use a smaller image for running the application
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /build/target/catalog-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8088

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "app.jar"]
