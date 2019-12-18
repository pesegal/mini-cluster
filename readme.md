# Mini Cluster
This is a learning project where I am trying to simulate a simple microservice cluster and to try out different tools and ideas. Some of the things I want to try are:

__Tooling / Utility__
1. Service Discovery (Consul)
2. Configuration Managment (Consul)
3. Secrets Management (Consul)
4. Distributed tracing 

__Message Passing Techniques__
1. REST
2. gRPC
3. Message Queueing

The technologies will be focused around Spring / JVM technologies first, but I might try out other frameworks in the future.

## Setup
In the root directory you can build the maven projects
using `mvn clean package` which will build and create docker containers for
each micro-service project. Once that has completed you can use `docker-compose up`
to start up all the microservices in a mini-cluster. `docker-compose down` will stop
the running cluster as well.

## Image Cleanup
The current docker container generation plugin leaves
dangling container images on your local docker. You can quickly clean them
up with:
```
docker rmi $(docker images -qa -f 'dangling=true')
```
