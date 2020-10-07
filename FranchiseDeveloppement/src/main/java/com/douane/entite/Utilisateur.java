package com.douane.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Utilisateur implements Serializable{
	@Id
	@SequenceGenerator (name = "generator_utilisateur", sequenceName = "U_SEQ", allocationSize = 1) 
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator_utilisateur")
	private Long idUtilisateur;
	private String matricule;
	private String login;
	private String poste;
	private String password;
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String nom) {
		this.login = nom;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Role getPassword() {
		return role;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public Utilisateur(String matricule, String nom,  Role role, String password) {
		super();
		this.matricule = matricule;
		this.login = nom;
		this.role = role;
		this.password = password;
	}	

	public Utilisateur(String matricule, String nom,  Role role, String password, String poste) {
		super();
		this.matricule = matricule;
		this.login = nom;
		this.role = role;
		this.poste = poste;
		this.password = password;
	}	
}
