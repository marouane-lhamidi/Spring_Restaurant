package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor
public class Commande  implements Serializable  {
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
	
	private Long idPlat ;
	private Long idBoisson ;
	private int quantityBoisson ;
	
	private boolean isReady;

	public Commande(Long idPlat, Long idBoisson, int quantityBoisson, boolean isReady) {
		super();
		this.idPlat = idPlat;
		this.idBoisson = idBoisson;
		this.quantityBoisson = quantityBoisson;
		this.isReady = isReady;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPlat() {
		return idPlat;
	}

	public void setIdPlat(Long idPlat) {
		this.idPlat = idPlat;
	}

	public Long getIdBoisson() {
		return idBoisson;
	}

	public void setIdBoisson(Long idBoisson) {
		this.idBoisson = idBoisson;
	}

	public int getQuantityBoisson() {
		return quantityBoisson;
	}

	public void setQuantityBoisson(int quantityBoisson) {
		this.quantityBoisson = quantityBoisson;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}




	
	
	
}
