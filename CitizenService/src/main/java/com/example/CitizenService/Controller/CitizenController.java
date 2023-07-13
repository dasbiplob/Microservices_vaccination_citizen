package com.example.CitizenService.Controller;

import com.example.CitizenService.Entity.Citizen;
import com.example.CitizenService.Repositories.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepo citizenRepo;


    @RequestMapping(name = "/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
        try{

            List<Citizen> citizenList = citizenRepo.findByVaccinationCenterId(id);


            return new ResponseEntity<>(citizenList,HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/addCitizen")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
        try {
            Citizen citizenObj = citizenRepo.save(citizen);
            return new ResponseEntity<>(citizenObj,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
