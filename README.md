# netflix-eureka-example

3 applications

- spring-boot-eureka-service

Runs Netflix Eureka service registry. 

Access console at http://localhost:8761/

- spring-boot-service-app

On service start-up registers with Eureka service. 

Provides restful endpoint at http://localhost:8060/hello

- spring-boot-client-app

Provides restful endpoint at http://localhost:8070/hello[?name=name]. 
This looks up service from Eureka and calls restful endpoint on service.

