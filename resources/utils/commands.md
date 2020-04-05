# Run Script
    ./resources/utils/compile-and-run-in-docker.sh
    
## Subir a dockerhub
    
    docker image build -f ./resources/docker/my-books-service/Dockerfile . -t aamv/my-books:latest
    docker push aamv/my-books:latest


## Tomar el jar y guardarlo en la imagen

    # Indicandole el contexto y el arcivo Dockerfile separados
    docker image build -f ./resources/docker/my-books-service/Dockerfile . -t aamv/my-books:latest
    docker image build . -t aamv/my-books:latest

## ARRANCAR
    # definitivo*************
    docker-compose -f ./resources/docker/docker-compose.yml up --build
    # ***********************
       
    docker-compose -f ./resources/docker/docker-compose.yml up
    docker-compose up
La ip del Host es 192.168.99.100

ruta ejemplo http://192.168.99.100:5000/v1/country

## crear base de datos
    cat documentacion/mislibros.sql | docker-compose exec -T db mysql -uaamv -paamv db
    # estando en la carpeta resources/docker
    cat ../database/sql-scripts/mybooks.sql | docker-compose exec -T db mysql -uroot -paamv mybooksdb

## asignar permisos
    docker exec -it mybooks_db_1 mysql -p
    GRANT [permiso] ON [nombre de bases de datos].[nombre de tabla] TO ‘[nombre de usuario]’@'localhost’;
    GRANT ALL PRIVILEGES ON mybooksdb.* TO 'aamv'@'%';
    
## Insert en consola sql
    INSERT INTO mybooksdb.country (name) VALUES ('Venezuela');

## mysql inline
    docker-compose exec -T db mysql -uaamv -paamv db <<< "INSERT INTO pais (nombre) VALUES ('PRUEBA')"
    docker-compose exec -T db mysql -uaamv -paamv db <<< "INSERT INTO estado (nombre, idpais) VALUES ('estado1', 1)"

## Compilar con maven sin correr las pruebas y no de el error de base de datos
    mvn clean install -DskipTests