Step-by-Step Guide to Running the Application

Step 1: Install Docker Desktop
Download Docker Desktop:

Go to the Docker Desktop download page and choose the version for your operating system (Windows, macOS, or Linux).
Install Docker:
Follow the installation instructions for your operating system to complete the setup.
After installation, open Docker Desktop and make sure it is running (you should see the Docker icon in your system tray).

Step 2: Install Postman
Download Postman:
Go to the Postman download page and download the latest version for your operating system.
Install Postman:
Follow the installation instructions to complete the setup.
Once installed, open Postman and ensure it's ready for sending HTTP requests.

Step 3: Start the Application Using Docker Compose
Navigate to the Application Directory:

Open a terminal or command prompt and navigate to the directory where your docker-compose.yml file is located.
Run Docker Compose:
Execute the following command to start the services defined in the docker-compose.yml file:

"docker-compose up"

This will start your application, including the PostgreSQL database and any other services.
Verify Services are Running:

Once the containers are up and running, Docker will display logs for each service. You can verify if the database 
and application services have started successfully.

Step 4: Use Postman to Interact with the Database
Create a New Request in Postman:

Open Postman and click the New button, then select HTTP Request.
Set the Request URL:

In the URL field, enter the following:
sql

http://localhost:8080/query/send?message=CREATE TABLE public.user (
id SERIAL PRIMARY KEY,
username VARCHAR(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);

This URL sends a query to create a user table in your PostgreSQL database.
You can use any sql commands along this path and see the result in the console 
