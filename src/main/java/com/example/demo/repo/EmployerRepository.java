package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.entities.Employer;


public interface EmployerRepository extends JpaRepository<Employer, Long>  {
	Employer findByNom(String Nom);

}
