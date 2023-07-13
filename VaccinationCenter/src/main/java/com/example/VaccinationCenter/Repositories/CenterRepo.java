package com.example.VaccinationCenter.Repositories;

import com.example.VaccinationCenter.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepo extends JpaRepository<VaccinationCenter,Integer> {

}
