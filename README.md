#Hospital Management System

Hospital Management System is web application created using Java, Spring Boot and SQL. 

## Docker Postgres Setup


Create Docker container with Postgres database:

`docker create --name hms -e POSTGRES_PASSWORD=password -p 5432:5432 postgres:11.5-alpine`

Start container:

`docker start hms`

Stop container:

`docker stop hms`

Connection Info:

JDBC URL: `jdbc:postgresql://localhost:5432/hms_app `

Username: `postgres`

Password: `password`

Note: This stores the data inside the container - when you delete the container, the data is deleted as well.

Connect to PSQL prompt from docker:
`docker exec -it hms psql -U postgres`


## Application Database Setup

Create the Database:

`psql> create database hms_app;`

Setup the Tables:

`psql -d hms_app -f create_tables.sql`

Install the Data:

`psql -d hms_app -f insert_data.sql`

Note: The if you are using Docker, the last two steps can be done like so:

Setup the Tables:

`docker cp create_tables.sql hms:/create_tables.sql
docker exec -it hms psql -d hms_app -f create_tables.sql -U postgres`

Install the Data:

`docker cp insert_data.sql hms:/insert_data.sql
docker exec -it hms psql -d hms_app -f insert_data.sql -U postgres`
