# Use an OpenJDK base image with Alpine for smaller image size
FROM openjdk:11

# Set an environment variable for the sentiment analysis logic API URL
ENV SA_LOGIC_API_URL=http://172.18.0.3:5000

# Copy the JAR file into the container at the root directory
ADD target/sentiment-analysis-web-0.0.1-SNAPSHOT.jar /sentiment-analysis-web.jar

# Inform Docker that the container listens on port 8080 at runtime
EXPOSE 8080

# Command to run the Java application, utilizing the environment variable for configuration
CMD ["java", "-jar", "/sentiment-analysis-web.jar", "--sa.logic.api.url=${SA_LOGIC_API_URL}"]
