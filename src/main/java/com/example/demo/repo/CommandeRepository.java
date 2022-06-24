package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entities.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Long>  {

}
