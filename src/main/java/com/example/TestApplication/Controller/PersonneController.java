package com.example.TestApplication.Controller;

import com.example.TestApplication.Entity.Personne;
import com.example.TestApplication.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/personne")
public class PersonneController {
    @Autowired
    PersonneService personneService;

    @PostMapping(value="/all", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public List<Personne> getAllPersonnes(){
        return personneService.findAllPersonnes();
    }


    @PostMapping(value="/ById", produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Personne getPersonneById(@RequestParam("id") String id){
        return personneService.findPersonneById(Long.parseLong(id));
    }





}
