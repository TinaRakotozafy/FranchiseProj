package com.douane.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Role implements Serializable{
	@Id
	@SequenceGenerator (name = "generator_role", sequenceName = "R_SEQ", allocationSize = 1) 
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_role")
	private Long IdRole;
	private String nom;
	public Role(String nom) {
		super();
		this.nom = nom;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
