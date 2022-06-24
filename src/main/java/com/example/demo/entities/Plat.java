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
public class Plat  implements Serializable {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
	
	@Column(length = 30, nullable = false)
    private String nom ;
	
	private Long idFruit ;
	private double quantityFruit ;
	
	private Long idViand ;
	private double quantityViad ;
	
	private Long idLegume ;
	private double quantityLegume ;
	
    private String image ;


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

	public Long getIdFruit() {
		return idFruit;
	}

	public void setIdFruit(Long idFruit) {
		this.idFruit = idFruit;
	}

	public double getQuantityFruit() {
		return quantityFruit;
	}

	public void setQuantityFruit(double quantityFruit) {
		this.quantityFruit = quantityFruit;
	}

	public Long getIdViand() {
		return idViand;
	}

	public void setIdViand(Long idViand) {
		this.idViand = idViand;
	}

	public double getQuantityViad() {
		return quantityViad;
	}

	public void setQuantityViad(double quantityViad) {
		this.quantityViad = quantityViad;
	}

	public Long getIdLegume() {
		return idLegume;
	}

	public void setIdLegume(Long idLegume) {
		this.idLegume = idLegume;
	}

	public double getQuantityLegume() {
		return quantityLegume;
	}

	public void setQuantityLegume(double quantityLegume) {
		this.quantityLegume = quantityLegume;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    
    

}
