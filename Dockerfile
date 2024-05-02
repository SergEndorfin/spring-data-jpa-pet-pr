FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root

COPY ./mysqlusers.sql /docker-entrypoint-initdb.d/

EXPOSE 3306
