# Start with a base image containing Java runtime
FROM adoptopenjdk/openjdk11:latest

# Add Maintainer Info
LABEL maintainer="alfredoalejandro05@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE1=target/mislibros-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE1} mislibros.jar

# Run the jar file 
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mislibros.jar"]
ENTRYPOINT ["java","-jar","/mislibros.jar"]