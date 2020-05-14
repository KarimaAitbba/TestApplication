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

	@Test
	void contextLoads() {
	}

}
