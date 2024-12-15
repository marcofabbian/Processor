# Use an official OpenJDK 17 image as the base
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Kotlin build files (e.g., JAR file) into the container
COPY build/libs/processor-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file with the Java command
CMD ["java", "-jar", "app.jar"]