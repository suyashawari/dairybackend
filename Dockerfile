# Stage 1: Build the application using the Gradle wrapper
FROM gradle:8.2-jdk17 AS build
WORKDIR /app

# Copy all project files to the container.
# The --chown option ensures the correct file ownership for the gradle user.
COPY --chown=gradle:gradle . .

# Ensure the Gradle wrapper has execute permissions.
RUN chmod +x gradlew

# Use the Gradle wrapper to build the executable JAR.
RUN ./gradlew bootJar --no-daemon

# Stage 2: Create a lightweight runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Adjust the JAR file name if needed.
COPY --from=build /app/build/libs/onlinedairy-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application uses.
EXPOSE 8080

# Run the Spring Boot application.
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# Use a lightweight runtime image
#FROM openjdk:17-jdk-slim
#WORKDIR /app
#
## Copy the pre-built JAR from your local machine into the image.
## Make sure the path matches your actual artifact.
#COPY build/libs/onlinedairy-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 8080
#
## Run the Spring Boot application.
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]
