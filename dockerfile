# Stage 1: Build the Maven project
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy the Maven project files
COPY . .

# Build the project and download dependencies (skip tests during build)
RUN mvn clean install -DskipTests

# Stage 2: Runtime with Chrome
FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /app

# Copy the built project from the builder stage
COPY --from=builder /app /app

# Install required dependencies for Chrome
RUN apt-get update && \
    apt-get install -y wget gnupg2 unzip curl xvfb && \
    curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google-linux-signing-keyring.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-linux-signing-keyring.gpg] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    rm -rf /var/lib/apt/lists/*

# Set environment variable for Chrome to run headless
ENV DISPLAY=:99

# Run tests
CMD ["mvn", "test"]
