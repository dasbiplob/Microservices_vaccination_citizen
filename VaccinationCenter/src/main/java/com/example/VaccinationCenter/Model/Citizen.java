package com.example.VaccinationCenter.Model;

import jakarta.persistence.*;
import lombok.*;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Citizen {

    private int id;
    private String name;
    private int vaccinationCenterId;
}
