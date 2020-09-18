#!/bin/bash
# Compila el proyecto
# Construye imagen basado en el proyecto compilado
# Levanta contenedor my-books
# Levanta contenedor mysql

# lanzar desde raiz del proyecto con:
# ./resources/utils/compile-and-run-in-docker.sh

mvn clean install -DskipTests

# Solucion provicional para no acumular tantas imagenes <none>
# Elimina todas las imagenes <none>
docker rmi $(docker images -f dangling=true -q)

docker-compose -f ./resources/docker/docker-compose.yml up --build