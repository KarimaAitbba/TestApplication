package com.example.TestApplication.Services;

import com.example.TestApplication.Entity.Personne;
import com.example.TestApplication.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    public PersonneService(){}
    public List<Personne> findAllPersonnes(){
      return  personneRepository.findAll();
    }

    public Personne findPersonneById(Long id){
        return  personneRepository.getOne(id);
    }


}
