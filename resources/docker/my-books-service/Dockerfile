# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11:latest

# Add Maintainer Info
LABEL maintainer=alfredoalejandro05@gmail.com

# Update environment
RUN apt-get update && apt-get install -y

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/my-books-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} my-books.jar

# Run the jar file 
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/my-books.jar"]
ENTRYPOINT ["java","-jar","/my-books.jar"]