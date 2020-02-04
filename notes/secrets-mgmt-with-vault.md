# Secrets Management w/ Vault

Now that we have gotten dynamic configuration pulling through Consul. You are probably wondering. What about secrets?
To clarify, secrets are any pieces of information that sensitive and need to stay private: 
- Passwords
- API Keys
- Tokens
- Ect.

How do we handle these secrets in a dynamic way? That is what this section will explore. To do this we will be using 
another HashiCorp tool called __Vault__. 

In this section we will implement the following things:
 1. Set up / configure Vault in the cluster.
 2. Connect to the database using service discovery
 3. Set up Vault Database secrets engine to dynamically generate user accounts.
 4. Connect Count service to PostgreSQL
 5. Make the count service persist to a PostgreSQL database.
 6. Connect front end to KV/STORE API keys.

# Dynamic Database Connections
