# Api Comparison Experiment - Master's thesis application

## Application

* port: 8888
* api path: `localhost:8888/api`
  * REST: `/rest/...`
  * GraphQL: `/graphql`
* Postman API Collection: [mgr.postman_collection.json](src/main/resources/mgr.postman_collection.json)

## Compatible database

* [github.com/sakiladb/mysql](https://github.com/sakiladb/mysql)
* database: sakila
* username: sakila
* password: p_ssW0rd
* how to run:
    ```shell
  docker run -p 3306:3306 -d sakiladb/mysql:latest
    ```


