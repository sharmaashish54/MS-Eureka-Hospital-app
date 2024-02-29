package com.practice.vaccinationcentre.vaccination.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.vaccinationcentre.vaccination.Entity.VaccinationCenter;
import com.practice.vaccinationcentre.vaccination.models.Citizen;
import com.practice.vaccinationcentre.vaccination.models.RequiredResponse;
import com.practice.vaccinationcentre.vaccination.repositories.VaccinationCentreRepository;



@RestController
@RequestMapping("/vaccinationcentre")
public class VaccinationCentreController {

    @Autowired
    private VaccinationCentreRepository repo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addVaccinationCentre(@RequestBody VaccinationCenter vaccinationCentre){
        VaccinationCenter vaccinationCentreAdded = repo.save(vaccinationCentre);
        return new ResponseEntity<>(vaccinationCentreAdded,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDatabyCenterId(@PathVariable Integer id){

RequiredResponse requiredResponse = new RequiredResponse();
//get vaccination centre details
VaccinationCenter vaccinationCenterDetails = repo.findById(id).get();
//get Citizen registered to vaccination
//To call a different service we need restTemplate
//Eureka service will identify the required load balanced service- service discovery.

@SuppressWarnings("unchecked")
List<Citizen> citizenDetails = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);

requiredResponse.setCentre(vaccinationCenterDetails);
requiredResponse.setCitizen(citizenDetails);

return new ResponseEntity<>(requiredResponse,HttpStatus.OK);

    }
    
}
