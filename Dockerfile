# Use a lightweight Java runtime
FROM openjdk:21-jdk-slim

# Add a volume to store temporary files (optional)
#VOLUME /tmp

# Copy the Spring Boot jar file into the container
COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]