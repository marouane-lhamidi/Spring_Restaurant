package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor
public class Viand  implements Serializable {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
    
	@Column(length = 30, nullable = false)
    private String nom ;
    
    private double quntity ;

	public Viand(String nom, double quntity) {
		super();
		this.nom = nom;
		this.quntity = quntity;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getQuntity() {
		return quntity;
	}

	public void setQuntity(double quntity) {
		this.quntity = quntity;
	}
    
    

}
