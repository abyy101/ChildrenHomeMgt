# Use an official JDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY Children_shomemanagement.jar /app/Children_shomemanagement.jar
# Expose the port your application will run on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "Children_shomemanagement.jar"]
