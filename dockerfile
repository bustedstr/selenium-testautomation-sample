# Use a base image with Java and Maven
FROM maven:3.8.5-openjdk-17

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Run tests
CMD ["mvn", "clean", "test"]
