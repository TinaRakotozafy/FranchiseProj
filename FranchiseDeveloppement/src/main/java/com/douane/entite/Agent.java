package com.douane.entite;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Agent implements Serializable {


	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator (name = "generator_agent", sequenceName = "AG_SEQ", allocationSize = 1) 
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_agent")
	private Long idAgent;
	
	private String nom;
	private String role;
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agent(String nom, String role) {
		super();
		this.nom = nom;
		this.role = role;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public Long getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(Long idAgent) {
		this.idAgent = idAgent;
	}
}
