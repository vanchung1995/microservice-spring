# microservice-spring
This project is a implementation of microservices architect using Spring Boot

In this project, we have 2 service: image and gallery. Both are RESTFUL API but gallery will call API to image to 
get data. I use Feign Client and RestTemplate to call API. We use eureka server for service registry. We use also an 
API gateway to redirect uri to respond service. We also have config service to centralize configurations.

This project is a module-base maven project. It includes modules:
1. eureka-server: This module is service registry
2. image-service: This module is a RESTFUL API service
3. gallery-service: This module is also a RESTFUL API service, but it calls image-service via Feign Client and 
   RestTemplate to get data
4. config-server: This module is a JDBC config server, centralized configuration
5. gateway-service: This module is an API Gateway  