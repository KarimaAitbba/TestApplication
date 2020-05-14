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
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.spy;

@SpringBootTest
@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.management.*")
@PrepareForTest({PersonneService.class})
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

    @Test
    public void findAllPersonne_WhenNotValidSize(){
        Personne personne = new Personne();
        personne.setPrenom("Test");
        List<Personne> listPersonne = new ArrayList<>();
        listPersonne.add(personne);

        assertThat(personneService.findAllPersonnes().size()).isEqualTo(1); }


    @Test
    public void findById_WhenIdValid(){
        Long id = Long.parseLong("1");
        Personne personne = personneService.findPersonneById(id);
        assertThat(personne).isNotNull();
    }
/*
	@org.junit.Test
	public void findById_WhenIdNotValid(){
		Long id = Long.parseLong("1");
		Personne personne = personneService.findPersonneById(id);
		assertThat(personne.getPrenom()).isNotEqualTo("prenom");
	}*/









}


