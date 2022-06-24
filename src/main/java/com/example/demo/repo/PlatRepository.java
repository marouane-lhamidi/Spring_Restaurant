package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entities.Plat;


public interface PlatRepository extends JpaRepository<Plat, Long>  {
	Plat findByNom(String Nom);

}
