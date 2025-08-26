
# DOC.md

## 🚀 Running the BayzDelivery Application

This document provides the steps required to run the Spring Boot application locally, utilizing the PostgreSQL database via Docker Compose.

### Prerequisites

1.  **Docker:** Ensure **Docker** (Docker Desktop for Windows/Mac or Docker Engine for Linux) is installed and running on your machine.
2.  **Java 17:** The application requires **Java Development Kit (JDK) 17** to run.
3.  **Build Tool:** You will need **Maven** or **Gradle** installed, or you can use the wrapper scripts (`mvnw` or `gradlew`) included in the project.

-----

## Step 1: Start the PostgreSQL Database

The `docker-compose.yml` file is configured to launch a PostgreSQL database container for your application.

1.  Navigate to the project's root directory (where the `docker-compose.yml` file is located) in your terminal.

2.  Run the following command to build and start the database container:

    ```bash
    docker compose up -d postgres
    ```

3.  **Important Note on Port Conflict:**
    The PostgreSQL container is configured to listen on port **5432**. If you have a **local PostgreSQL server** running on your machine, it will conflict with the container's port. You have two options:

      * **Option A (Recommended):** Turn off your local PostgreSQL service (using Windows Services or the appropriate command for your OS).
      * **Option B:** Change the container's published port in the `docker-compose.yml` file (e.g., change `"5432:5432"` to `"5433:5432"`).

-----

## Step 2: Run the Spring Boot Application

Once the database is up and running, you can start the application.

### Option A: Run via IDE (IntelliJ IDEA)

1.  Open the project in your JetBrains Java IDE (IntelliJ IDEA).
2.  Navigate to the main application file:
      * `src/main/java/com/bayzdelivery/BayzDeliveryApplication.java`
3.  Right-click the file or the `main` function and select **Run 'BayzDeliveryApplication.main()'**.

### Option B: Run via Command Line

1.  Navigate to the project's root directory in your terminal.

2.  Use the project's build tool wrapper to run the application:

    **Using Gradle:**

    ```bash
    ./gradlew bootRun
    ```

The application will now connect to the running PostgreSQL container and start. You can then interact with the API endpoints (e.g., `http://localhost:8081/api/person`) using Postman or any other API client.