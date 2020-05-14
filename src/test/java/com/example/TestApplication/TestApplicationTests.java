package com.example.TestApplication;

import com.example.TestApplication.Entity.Personne;
import com.example.TestApplication.Repository.PersonneRepository;
import com.example.TestApplication.Services.PersonneService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.spy;

@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
class TestApplicationTests {
	@Mock
	PersonneRepository personneRepository;

	@InjectMocks
	PersonneService personneService;

	@Test
	void contextLoads() {
	}
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
		assertThat(personneService.findAllPersonnes().size()).isEqualTo(0); }

	//je savais deja ce que la repository va me retourner(mock), je test l action du service
	@Test
	public void findAllPersonne_WhenNotValidSize(){
		Personne personne = new Personne();
		personne.setPrenom("Test");
		List<Personne> listPersonne = new ArrayList<>();
		listPersonne.add(personne);

		assertThat(personneService.findAllPersonnes().size()).isEqualTo(0); }


	@Test
	public void findById_WhenIdValid(){
		Long id = Long.parseLong("1");
		Personne personne = personneService.findPersonneById(id);
		assertThat(personne).isEqualTo(null);
	}
/*
	@org.junit.Test
	public void findById_WhenIdNotValid(){
		Long id = Long.parseLong("1");
		Personne personne = personneService.findPersonneById(id);
		assertThat(personne.getPrenom()).isNotEqualTo("prenom");
	}*/




}
