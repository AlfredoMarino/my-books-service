#!/bin/bash
# Compila el proyecto
# Construye imagen basado en el proyecto compilado
# Levanta contenedor my-books
# Levanta contenedor mysql

# lanzar desde raiz del proyecto con:
# ./resources/utils/compile-and-run-in-docker.sh

mvn clean install -DskipTests
docker-compose -f ./resources/docker/docker-compose.yml up --build