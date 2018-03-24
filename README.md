MicroProfile OpenAPI Demo with WildFly Swarm
===

This project is MicroProfile OpenAPI Demonstration with WildFly Swarm.

## Build

```
mvn clean package
```

## Run

```
java -jar target/demo-swarm.jar
```

<p class="warn">Cannot run with `mvn wildfly-swarm:run`. Please see  https://issues.jboss.org/browse/SWARM-1890</p>

## Use

To `GET` the JAX-RS resource

```
http://localhost:8080/api/hello
```


To `GET` the API Specification as a `OpenAPI` document.

```
http://localhost:8080/openapi

# Documentation powered by ReDoc
http://localhost:8080/
```
