package com.practice.vaccinationcentre.vaccination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableHystrix
public class VaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationApplication.class, args);
	}

//By Using Load balancer, the eureka service will automatically 
//identify the other service called from this service when call using resttemplate
@Bean
@LoadBalanced
public RestTemplate getRestTemplate(){
	return new RestTemplate();
}	

}
