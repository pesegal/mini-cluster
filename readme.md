# Mini Cluster
This is a learning project where I am trying to simulate a simple microservice cluster and to try out different tools and ideas. Some of the things I want to try are:

__Infrastructure Tooling / Utility__
1. Service Discovery (Consul)
2. Configuration Managment (Consul)
3. Dynamic Secrets Management (Consul + Vault)
4. Service Mesh + L7 Routing (Envoy Proxy)
5. Distributed tracing (Perf Monitoring)
6. API Gateway Integration?


__Message Passing Techniques__
1. REST
2. gRPC
3. Message Queueing

__Distributed Transactions__
1. Eventual Consistency / Saga 
2. Circuit Breaker

The technologies will be focused around Spring / JVM technologies first, but I might try out other frameworks (node.js) in the future.

In addition, I will be providing write up's to provide context to each exploration. Links to writeups:
1. [Introduction Service Discovery with Consul](notes/consul-presentation-outline.md)
2. [Distributed Configuration Management with Consul](notes/consul-for-configuration-mgmt.md)
3. [Dynamic Secrets Management with Vault](notes/secrets-mgmt-with-vault.md)

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

## Scaling Container To Show Loadbalancing
```bash
// Scales count service to three instances.
docker-compose up --scale count-service=3
```