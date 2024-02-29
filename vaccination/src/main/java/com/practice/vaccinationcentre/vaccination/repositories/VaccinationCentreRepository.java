package com.practice.vaccinationcentre.vaccination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.vaccinationcentre.vaccination.Entity.VaccinationCenter;

public interface VaccinationCentreRepository extends JpaRepository<VaccinationCenter, Integer>{


    
}
