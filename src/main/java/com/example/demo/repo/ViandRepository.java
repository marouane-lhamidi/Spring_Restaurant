package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Viand;


public interface ViandRepository extends JpaRepository<Viand, Long>  {
	Viand findByNom(String Nom);

}
