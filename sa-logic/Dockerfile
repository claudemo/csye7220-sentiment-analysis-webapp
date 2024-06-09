FROM python:3.10-alpine
# Set the working directory to /app, making it the default directory for all subsequent commands
WORKDIR /app

# Copy the application source code (assuming 'sa' directory contains your Python application) to /app in the container
COPY sa /app


# Install the Python dependencies listed in requirements.txt
# Also, install necessary packages to ensure successful builds of any dependencies
RUN pip3 install --no-cache-dir -r requirements.txt --verbose \
    && python -m textblob.download_corpora

# Inform Docker that the container listens on port 5000 at runtime
EXPOSE 5000

# Define the command to run the application using Python
# Utilizing environment variables for configuration
ENTRYPOINT ["python"]
CMD ["sentiment_analysis.py", "--sa.logic.api.url=${SA_LOGIC_API_URL}"]
