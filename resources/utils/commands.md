## Tomar el jar y guardarlo en la imagen

    # Indicandole el contexto y el arcivo Dockerfile separados
    docker image build -f ./resources/docker/my-books-service/Dockerfile . -t my-books:latest
    docker image build . -t my-books:latest

## ARRANCAR

    docker-compose -f ./resources/docker/docker-compose.yml up
    docker-compose up
La ip del Host es 192.168.99.100

ruta ejemplo http://192.168.99.100:5000/v1/pais

## crear base de datos
    cat documentacion/mislibros.sql | docker-compose exec -T db mysql -uaamv -paamv db
    cat resources/database/mybooks.sql | docker-compose exec -T db mysql -uroot -paamv mybooksdb

## asignar permisos
    docker exec -it mybooks_db_1 mysql -p
    GRANT [permiso] ON [nombre de bases de datos].[nombre de tabla] TO ‘[nombre de usuario]’@'localhost’;
    GRANT ALL PRIVILEGES ON mybooksdb.* TO 'aamv'@'%';


## mysql inline
    docker-compose exec -T db mysql -uaamv -paamv db <<< "INSERT INTO pais (nombre) VALUES ('PRUEBA')"
    docker-compose exec -T db mysql -uaamv -paamv db <<< "INSERT INTO estado (nombre, idpais) VALUES ('estado1', 1)"

## Compilar con maven sin correr las pruebas y no de el error de base de datos
    mvn clean install -DskipTests