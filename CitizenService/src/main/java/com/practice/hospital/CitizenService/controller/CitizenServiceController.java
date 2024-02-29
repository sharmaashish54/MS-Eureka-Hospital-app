package com.practice.hospital.CitizenService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hospital.CitizenService.Entity.Citizen;
import com.practice.hospital.CitizenService.repositories.CitizenRepository;



@RestController
@RequestMapping("/citizen")
public class CitizenServiceController {

    @Autowired
    private CitizenRepository repo;

    @RequestMapping("/get")
    public ResponseEntity<String> test(){
      return new ResponseEntity<>("hello",HttpStatus.OK);
    }

    @RequestMapping("/id/{id}")
    public ResponseEntity<java.util.List<Citizen>> getById(@PathVariable Integer id){
        java.util.List<Citizen> citizenList = repo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(citizenList,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
        Citizen citizen = repo.save(newCitizen);
        return new ResponseEntity<>(citizen,HttpStatus.OK);
    }
}
