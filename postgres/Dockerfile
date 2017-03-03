# Dockerizing the database: Dockerfile for building Postgres images
FROM postgres:9.6

RUN mkdir /docker-entrypoint-initdb.d/entries

# Initialization sql and shell scripts are copy in the init db entrypoint directory and will be run 
# when image is build.
COPY ./init/*.sql ./init/*.sh /docker-entrypoint-initdb.d/
