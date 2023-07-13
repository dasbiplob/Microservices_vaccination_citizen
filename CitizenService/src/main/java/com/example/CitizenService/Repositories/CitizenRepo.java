package com.example.CitizenService.Repositories;

import com.example.CitizenService.Entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Integer> {
    public List<Citizen> findByVaccinationCenterId(Integer id);
}
