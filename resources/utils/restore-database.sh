#!/bin/bash
# Restaura base de datos

# lanzar desde raíz del proyecto con:
# ./resources/utils/restore-database.sh

mvn flyway:clean
mvn flyway:info
mvn flyway:migrate
mvn flyway:validate
mvn flyway:info