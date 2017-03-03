#!/bin/bash
set -e
# Stop and remove running containers
docker ps -q -a --filter="name=jcd-recruiting" | xargs docker rm -vf || true
# Build or force rebuild of the image postgres-storage
docker build -t jcd-recruiting:latest --no-cache .
# Run container from jcd-recruiting image on port 5433
docker run --name jcd-recruiting -v $(pwd)/entries:/docker-entrypoint-initdb.d/entries -e POSTGRES_PASSWORD=jcd -p 5433:5432 jcd-recruiting:latest
