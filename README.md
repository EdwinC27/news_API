# Get news from various topics

This repository implements a RESTful API that allows you to search for news based on date range, category, domain, and today's news.
<br>

### To use this service, you can do so by following the URLs:

> {{fixed URL}}news_today?type=apple

> {{fixed URL}}news_domain?domains=thenextweb.com

> {{fixed URL}}news_today?type=bitcoin&from=2023-12-28&to=2024-01-27

> {{fixed URL}}news_category?category=entertainment
<br>

## Environment:
- To use this program, it is necessary for your operating system to have Java 17 installed. If you don't have Java installed, you can download and install the corresponding version, for example, from the following page: https://adoptium.net/temurin/releases/.

- It is essential to have a PostgreSQL database. In the **dockerDir** folder, there is a file <a href="https://github.com/EdwinC27/news_API/blob/main/dockerDir/create_table.sql">create_table.sql</a> with the commands to create the corresponding tables.

- Change the username, password, and database name in the file <a href="hhttps://github.com/EdwinC27/news_API/blob/main/src/main/resources/application-dev.properties">application-dev.properties</a> located in the path **src/main/resources** according to your credentials.

- Modify the file named <a href="https://github.com/EdwinC27/news_API/blob/main/src/main/resources/service.properties">service.properties</a> in the **src/main/resources** folder, where you need to input the requested values for authentication.

- Ensure that you have this information correct and up-to-date before running the program.
<br>

## Initialization
To use this project, you can follow the instructions below:

### Download the project as a compressed .zip file
1. Download the project in .zip format from the "Code" option of this repository.
2. Once downloaded, unzip the file and open the project folder.
3. Modify the file **service.properties** located in the path **src/main/resources**, adding the necessary data for authentication towards the API. You should use your own authentication data.
4. Implement the corresponding PostgreSQL database
   - You can change the database name.
   - In the **dockerDir** directory, there is a file named **create_table.sql** with the commands to create the necessary table (this table must have the same name).
5. Finally, to run the application, use the command:
     ```  
       mvn spring-boot:run  
     ```
     This command will start the application using Maven and Spring Boot. Once the application is running, you can begin using it.
<br>

### Clone the Repository
1. Clone the Git repository to your PC using the following command:
    ```  
       git clone git@github.com:EdwinC27/news_API.git
    ```
2. Once downloaded, open the project folder.
3. Modify the file **service.properties** located in the path **src/main/resources**, adding the necessary data for authentication towards the API.
4. Implement the corresponding PostgreSQL database
   - You can change the database name.
   - In the **dockerDir** directory, there is a file named **create_table.sql** with the commands to create the necessary table (this table must have the same name).
5. Finally, to run the application, use the command:
     ```  
       mvn spring-boot:run  
     ```
     This command will start the application using Maven and Spring Boot. Once the application is running, you can begin using it.
