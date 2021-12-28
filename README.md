# MyBooksService

![my-books-image](resources/doc/my_books_logo.png)

This is the backend service of the My books project, which allows you to search, register and rate the books you have read.
In future releases it will be possible to scale and implement new functionalities such as:
- Login and profile
- Book recommendations according to categories and authors.
- Trade of books with other users

This project exposes a REST API and the project is based on a spring-boot application and saves the data in a MySQL database

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- docker
- java 11
- maven

### Install

- Clone this repo
```sh
$ git clone https://github.com/AlfredoMarino/my-books-service.git

$ cd my-books-service
```

- Execute Docker compose to start the entire my-books ecosystem (database, backend, and frontend)
```sh
$ docker-compose -f resources/docker/docker-compose.yml up
```
At this point, you can already test the application since the last docker image of this application is running. Go to http://localhost/

If you need to run the test environment follow the following steps:

As an alternative to start the whole my-books ecosystem, you can only start the my-books-database container which is the only one required by the my-books-service backend
```sh
$ docker-compose -f resources/docker/docker-compose.yml up my_books_database
```

- Start development environment
```sh
$ mvn clean install

$ mvn spring-boot:run
```
In this way, the test environment will start on port 8080.
You can check in your browser by doing get to:

http://localhost:8080/my-books-service/api/v1/books?name=Rayuela

Also, I included a collection of postman requests so that you can run your tests more easily

[postman-collection](resources/utils/my-books-api.postman_collection.json)

enjoy it :)

## Related projects

+ [my-books-ui](https://github.com/AlfredoMarino/my-books-ui)
+ [my-books-mysql](https://github.com/AlfredoMarino/my-books-mysql)
+ [my-books-gke](https://github.com/AlfredoMarino/my-books-gke)
+ [My docker-hub](https://hub.docker.com/u/aamv)

## Contributing

Pull requests are welcome.
