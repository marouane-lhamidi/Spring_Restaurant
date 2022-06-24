package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entities.Boisson;


public interface BoissonRepository extends JpaRepository<Boisson, Long>  {
	Boisson findByMarque(String Nom);


}
