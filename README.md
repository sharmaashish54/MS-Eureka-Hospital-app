**Introduction
**
This project demonstrates a simple two-microservice architecture built in Java, using Spring Boot and other microservice-related technologies:

Microservices:
Vaccination Center: Manages vaccination center details, schedules, and potentially registrations.
Citizen Service: Handles citizen information, appointments, and potentially interactions with the Vaccination Center.
Eureka Server: Acts as the central service registry for discovering microservices.
Dependencies

Spring Boot
Spring Cloud Discovery Client (Eureka)
Spring Cloud OpenFeign (for load balancing and fault tolerance)
Hystrix (for circuit breaker pattern)
Microservices

1. Vaccination Center

Maven package: com.practice.vaccinationcentre.vaccination
Main class: VaccinationCenterApplication
Spring Boot application annotations:
@SpringBootApplication
@EnableEurekaServer (if this microservice also acts as the Eureka Server)
Additional features (to be implemented):
Database integration (e.g., JPA) for persistent storage of vaccination center data
REST API endpoints for managing vaccination center details, schedules, and potentially registrations
2. Citizen Service

Maven package: com.practice.hospital.CitizenService
Main class: CitizenServiceApplication
Spring Boot application annotations:
@SpringBootApplication
@EnableDiscoveryClient (registers with Eureka Server)
Bean configuration:
Create a @FeignClient bean annotated with:
name (name of the service to interact with, e.g., "vaccination-center")
url (Eureka Server URL to discover the service dynamically)
Configure @FeignClient beans with appropriate annotations for request/response types (e.g., @GetMapping, @PostMapping) and path mappings for desired API endpoints of the Vaccination Center.
Service class (optional):
Create a service class to interact with the Feign client, encapsulating API calls and business logic.
Example Code Snippets (Citizen Service)

Building and Running

Build each microservice: mvn clean install
Run the Eureka Server (if not already running): java -jar vaccination-center/target/vaccination-center-*-*.jar --server.port=8761 
Run the Citizen Service: java -jar citizen-service/target/citizen-service-*-*.jar --spring.application.name=citizen-service
Testing

Access the Citizen Service endpoint (if applicable) based on its specific configuration and functionality.
Ensure proper interactions between microservices, including:
Service discovery through Eureka Server
Load balancing using @FeignClient annotation
Circuit breaker functionality using Hystrix in case of service failures

Attached locally tested postman in postman folder.





git init
git add .
git commit -m "Add existing project files to Git"
git remote add origin https://github.com/cameronmcnz/example-website.git
git push -u -f origin master
