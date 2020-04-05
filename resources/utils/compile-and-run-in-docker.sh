#!/bin/bash

mvn clean install -DskipTests

docker image build -f ./resources/docker/my-books-service/Dockerfile . -t my-books:latest

docker-compose -f ./resources/docker/docker-compose.yml up --build