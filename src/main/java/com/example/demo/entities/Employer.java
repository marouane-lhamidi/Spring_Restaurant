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
public class Employer  implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)    
    private Long id ;
    
	@Column(length = 30, nullable = false)
    private String nom ;
	
	@Column(length = 30, nullable = false)
    private String preNom ;
	
	@Column(length = 30, nullable = false)
    private String post ;
	
	@Column(length = 30, nullable = false)
    private String motPass ;

	public Employer(String nom, String preNom, String post, String motPass) {
		super();
		this.nom = nom;
		this.preNom = preNom;
		this.post = post;
		this.motPass = motPass;
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

	public String getPreNom() {
		return preNom;
	}

	public void setPreNom(String preNom) {
		this.preNom = preNom;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getMotPass() {
		return motPass;
	}

	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	
	
	
	

}
