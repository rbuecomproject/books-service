FROM openjdk:17-jdk-slim

# Set work directory
WORKDIR /app

# Copy the built jar to the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

#docker build -t books-service:latest .
#docker tag books-service:latest rbutechnologies/books-service:latest
#docker login
#docker push rbutechnologies/books-service:latest