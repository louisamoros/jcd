# jcd

Requirements:
 - `docker`
 - `maven`
 - `jdk8`

Run postgres: 
 - `cd postgres`
 - `./rebuild.sh` start a container with postgres db and dump datas
 
Run project:
 - `mvn clean install`
 - `mvn spring-boot:start`
 
API:
 - create : `post localhost:8080/developper`
 - update : `put localhost:8080/developper/{ - 81dcb39c-7d6f-4ca7-8630-aafcb41e2c37 - }`
 - get : `get localhost:8080/developper/{ - 81dcb39c-7d6f-4ca7-8630-aafcb41e2c37 - }`
 - get all : `get localhost:8080/developper`