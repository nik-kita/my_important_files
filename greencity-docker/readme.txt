REQUIRMENTS
Latest docker and docker-compose installed on your system.

LAUNCH
1)"docker-compose up" launch containers and aggregate the output of each container - ctrl + c to exit
2)"docker-compose up -d" launch conrainers in background

DELETE
1)"docker container rm -f $(docker container ls -aq)" remove all containers
2)"docker rmi -f $(docker images -a -q)" remove all images
3)"docker volume rm greencity-docker_postgres-data" remove postgress volume - beware, it will remove all database data
4)"docker volume rm greencity-docker_rabbitmq-data" remove rabbitmq volume

INFO
1)"docker ps -a" list all containers
2)"docker images" list images
3)"docker network ls" list networks
4)"docker volume ls" list volumes

GENERAL
http://<your_ip>:8080/swagger-ui.html#/ to access Swager

Note!
1)For better experience work in cloud platforms (because of the high internet connection).
2)If you want to have fresh docker containers, you have to remove images with old github sources. (In my case, I just have to execute 1) and 2) delete commands 
and then launch the infrustructure again.
3)google-creds.json, env_file, env_postgres - they all are secret files.

For more information read the docker and docker-compose documentation.

 

