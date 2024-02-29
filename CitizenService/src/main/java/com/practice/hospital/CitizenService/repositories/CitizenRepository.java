package com.practice.hospital.CitizenService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.hospital.CitizenService.Entity.Citizen;
import java.util.List;


public interface CitizenRepository extends JpaRepository<Citizen, Integer>{

    public List<Citizen> findByVaccinationCenterId(int vaccinationCenterId);
    
}
