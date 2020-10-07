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
	private String nom;
	private String prenom;
	private String matricule;
	private String login;
	private String poste;
	private String password;
	private int active;
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
	public String getPassword() {
		return password;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Utilisateur(String nom, String prenom, String matricule, String login, String poste, String password,
			Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.login = login;
		this.poste = poste;
		this.password = password;
		this.role = role;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
		
}
