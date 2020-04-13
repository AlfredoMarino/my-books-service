#!/bin/bash
# Restarua base de datos

# lanzar desde raiz del proyecto con:
# ./resources/utils/restore-database.sh

mvn flyway:clean
mvn flyway:info
mvn flyway:migrate
mvn flyway:validate
mvn flyway:info