package com.practice.vaccinationcentre.vaccination.models;

import java.util.List;

import com.practice.vaccinationcentre.vaccination.Entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

    private VaccinationCenter centre;
    private List<Citizen> citizen;
    
}
