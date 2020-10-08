package com.douane.metier.utilisateur;

import java.util.List;

import com.douane.entite.Utilisateur;

public interface IUtilisateur {
	void updateUtilisateur(Utilisateur utilisateur, Long id);
	void saveUtilisateur(Utilisateur utilisateur);
	void dellUtilisateur(Long id);
	List<Utilisateur> findAllUtilisateur();
	Utilisateur findByLogin(String login);
}
