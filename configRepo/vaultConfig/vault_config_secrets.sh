# Run this script after starting up the cluster to configure dynamic database credentials.
VAULT_TOKEN="vault_dev"

# Enable Secrets Engine
curl --header "X-Vault-Token: $VAULT_TOKEN" \
     --request POST \
     --data @enable_database_secrets_engine.json \
     http://localhost:8200/v1/sys/mounts/database

# Execute API commands to set up postgres database engine via HTTP
curl --header "X-Vault-Token: $VAULT_TOKEN" \
     --request POST \
     --data @postgres_engine.json \
     http://localhost:8200/v1/database/config/count-service

# Execute API commands to create the count-service role.
curl --header "X-Vault-Token: $VAULT_TOKEN" \
     --request POST \
     --data @count_service_role.json \
     http://localhost:8200/v1/database/roles/count-service