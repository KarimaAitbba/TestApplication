package com.example.TestApplication.Service;


import com.example.TestApplication.Entity.Personne;
import com.example.TestApplication.Repository.PersonneRepository;
import com.example.TestApplication.Services.PersonneService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.spy;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
public class PersonneServiceTest {

    @Mock
    PersonneRepository personneRepository;

    @InjectMocks
    PersonneService personneService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        personneService = spy(personneService);
        Personne personne = new Personne();
        personne.setPrenom("Test");
        List<Personne> listPersonne = new ArrayList<>();
        listPersonne.add(personne);
        Mockito.when(personneRepository.findAll()).thenReturn(listPersonne);
        Mockito.when(personneRepository.getOne(Long.parseLong("1"))).thenReturn(personne);
    }
    @Test
    public void findAllPersonne_WhenValidSize(){
        assertThat(personneService.findAllPersonnes().size()).isEqualTo(1); }

    //je savais deja ce que la repository va me retourner(mock), je test l action du service
    @Test
    public void findAllPersonne_WhenNotValidSize(){
        Personne personne = new Personne();
        personne.setPrenom("Test");
        List<Personne> listPersonne = new ArrayList<>();
        listPersonne.add(personne);

        assertThat(personneService.findAllPersonnes().size()).isEqualTo(listPersonne.size()); }


        @Test
    public void findById_WhenIdValid(){
        Long id = Long.parseLong("1");
        Personne personne = personneService.findPersonneById(id);
        assertThat(personne.getPrenom()).isEqualTo("Test");
    }

    @Test
    public void findById_WhenIdNotValid(){
        Long id = Long.parseLong("1");
        Personne personne = personneService.findPersonneById(id);
        assertThat(personne.getPrenom()).isNotEqualTo("prenom");
    }






}


