package com.example.TestApplication.Repository;

import com.example.TestApplication.Entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonneRepository extends JpaRepository<Personne, Long>{

}
