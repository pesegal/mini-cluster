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

This writeup will explore how to do _application_ configuration management using versioned configuration
using `git` + `consul` + `spring-consul-config`.

#### Some of the goals we want from a configuration standpoint:
1. Configuration changes should be version controlled: _We want
to be able to track when configuration changes where made and by whom and have the human review process._
2. Configuration changes should happen without re-deploying the service: _The point
of making something configurable is allow changes to the operation of the service without code
changes. If we can get low-impact config changes it will allow us to do feature flags easily with low impact.
3. Configuration should be hierarchical: _Properties should be set by the most specific config
to the least specific and have sane defaults._
4. Configuration Profiles should be able to be mixed and matched: _This allows us to do feature flags gives us flexability._



### OUTLINE

- Define the example scenario.
- Show the basic solution with application.properties.
- Show how version control gets populated to consul via git2consul.
- Show how using spring actuator you can do a manual refresh of the config property.
- Show how to do automatic config refreshes using _config watch_ turned on.
- Consul as distributed configuration management.
- Dynamic
- Vault as secret store
    - Dynamically allocated database connections.
    
### STRETCH GOALS
- Add database connection to count service.
- Set up service discovery for Database using Consul.
- Set up vault to dynamically create logins for service. 