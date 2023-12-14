# Use an official AdoptOpenJDK 17 slim base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /spring-boot-app

# Copy the application source code into the container
COPY . /spring-boot-app

# Expose the port the app runs on
EXPOSE 8080

# Run the application using spring-boot:run
CMD ["./mvnw", "spring-boot:run"]