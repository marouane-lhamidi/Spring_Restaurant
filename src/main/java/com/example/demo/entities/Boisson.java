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
public class Boisson  implements Serializable {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
    
	@Column(length = 30, nullable = false)
    private String genre ;
	
	@Column(length = 30, nullable = false)
    private String marque ;
    
    private int quntity ;

	public Boisson(String nom, String marque, int quntity) {
		super();
		this.genre = nom;
		this.marque = marque;
		this.quntity = quntity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	
	
    
    

}
