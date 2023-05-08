#
# Build stage
#
#FROM maven:3.5-jdk-8 AS build
#COPY src /usr/src/app/src
#COPY pom.xml /usr/src/app
#RUN mvn -X -f /usr/src/app/pom.xml clean package
##
## Package stage
##
#FROM openjdk:17
##ARG JAR_FILE=/usr/src/app/target/*.jar
##COPY ${JAR_FILE} app.jar
#COPY --from=build /usr/src/app/target/*.jar /usr/app/app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

# ----------------------------------------------


# Set the base image to a Maven 3.8.3 with OpenJDK 17 runtime image
FROM maven:3.8.3-openjdk-17-slim AS build

# Set the default shell to bash
SHELL ["/bin/bash", "-c"]
# Copy the pom.xml file into the container
COPY pom.xml .

# Copy the source code into the container
COPY src/ ./src/

# Build the application using Maven
RUN mvn package -DskipTests

# Create a new stage for the runtime image
FROM openjdk:17 as runtime

# Set the working directory to /app
WORKDIR /app

# Copy the built JAR file from the build stage to the runtime stage
COPY --from=build /target/*.jar myapp.jar

# Expose the default HTTP port for the application
EXPOSE 8080

# Start the application
CMD ["java", "-jar", "myapp.jar"]