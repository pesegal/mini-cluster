# Mini Cluster
This is a learning project where I am trying to simulate a simple microservice cluster and to try out different tools and ideas.

There are now two versions of this project. One based on deployment via Kubernetes, and the other using Hashicorp utilities: Consul and Vault.
To see the Consul and Vault based implementation check out the `consul-value-example` branch. 

These are the ideas I want to explore:


__Infrastructure Tooling / Utility__
1. Service Discovery 
2. Configuration Management
3. Dynamic Secrets Management
4. Service Mesh + L7 Routing
5. Distributed tracing
6. API Gateway Integration


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
Create a local postgres database called `count_service`. Then run an instance of count service.
Once that is running start up and instance of front-end.

In the root directory you can build the maven projects
using `mvn clean package` which will build and create docker containers for
each micro-service project.

## Image Cleanup
The current docker container generation plugin leaves
dangling container images on your local docker. You can quickly clean them
up with:
```
docker rmi $(docker images -qa -f 'dangling=true')
```