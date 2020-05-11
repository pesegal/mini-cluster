-- This is executed upon initialization of the database docker image
-- (note will not run again if data dir exists: check volumes if you have trouble)
-- docker inspect postgres-dev | grep volume
-- docker volume rm `volume-id`
create DATABASE count_service;