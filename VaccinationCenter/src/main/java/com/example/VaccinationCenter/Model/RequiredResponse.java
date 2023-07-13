package com.example.VaccinationCenter.Model;

import com.example.VaccinationCenter.Entity.VaccinationCenter;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequiredResponse {

    private VaccinationCenter vaccinationCenter;
    private List<Citizen> citizenList;
}
