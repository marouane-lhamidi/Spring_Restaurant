package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entities.Legume;


public interface LegumeRepository extends JpaRepository<Legume, Long>  {
	Legume findByNom(String Nom);

}
