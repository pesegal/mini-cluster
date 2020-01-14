# Distributed Configuration Management

The second cool feature we can use is Consul distributed configuration management tooling.


Configuration management as a term can be confusing. Let's clarify
a bit. I think most people who are familiar with DevOps will probably think
of one of the big three _configuration management tools_:

 - __Ansible__
 - __Chef__ 
 - __Puppet__
 
Indeed, all of these tools can be used to solve the problems of configuration 
management, however all of these seem to take an _infrastructure_ focused approach, 
while _Consul's_ configuration solution is _application_ focused. In fact, we will probably use
a combination of both technologies to give us flexability.



### OUTLINE

- Consul as distributed configuration management.
- Dynamic
- Vault as secret store
    - Dynamically allocated database connections.