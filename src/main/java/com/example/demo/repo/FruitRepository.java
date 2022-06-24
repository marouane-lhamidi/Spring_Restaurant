package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entities.Fruit;


public interface FruitRepository extends JpaRepository<Fruit, Long>  {
	Fruit findByNom(String Nom);

}
