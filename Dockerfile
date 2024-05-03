FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root

COPY ./src/main/resources/scripts/mysqlusers.sql /docker-entrypoint-initdb.d/

EXPOSE 3306
