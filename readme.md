# Api Comparison Experiment - Master's thesis application

* api path: `localhost:8888/api`
  * REST: `/rest/...`
  * GraphQL: `/graphql`
* api path gRPC: `localhost:8889`
* Postman API Collection
  * [REST](src/main/resources/mgr-REST.postman_collection.json)
  * [GraphQL](src/main/resources/mgr-GraphQL.postman_collection.json)

## gRPC Protobuf generation

``` shell
mvn protobuf:compile protobuf:compile-custom -f pom.xml
```

Maven run configuration is also stored in [.run/](.run/) directory.

## Compatible database

* [github.com/sakiladb/mysql](https://github.com/sakiladb/mysql)
* database: sakila
* username: sakila
* password: p_ssW0rd
* how to run:
    ```shell
    docker run -p 3306:3306 -d sakiladb/mysql:latest
    ```

## Important files

* [gRPC Protobuf files](src/main/proto)
* [GraphQL schema files](src/main/resources/graphql)
* [application.properties](src/main/resources/application.properties)
* [entry point - ApiApplication.java](src/main/java/com/lesniewicz/api/ApiApplication.java)