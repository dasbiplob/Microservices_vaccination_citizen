package com.example.VaccinationCenter.Controller;

import com.example.VaccinationCenter.Entity.VaccinationCenter;
import com.example.VaccinationCenter.Model.Citizen;
import com.example.VaccinationCenter.Model.RequiredResponse;
import com.example.VaccinationCenter.Repositories.CenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    private CenterRepo centerRepo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter){
        try{
            VaccinationCenter vaccinationCenterObj = centerRepo.save(vaccinationCenter);
            return new ResponseEntity<>(vaccinationCenterObj,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDataByCenterId(@PathVariable Integer id){

            RequiredResponse requiredResponse = new RequiredResponse();
            //1st get vaccination center Details
            VaccinationCenter vaccinationCenter = centerRepo.findById(id).get();
            requiredResponse.setVaccinationCenter(vaccinationCenter);

            //Then get all the citizen registered to vaccination canter
            List<Citizen> citizenList = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
            requiredResponse.setCitizenList(citizenList);
            return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
    }
}
