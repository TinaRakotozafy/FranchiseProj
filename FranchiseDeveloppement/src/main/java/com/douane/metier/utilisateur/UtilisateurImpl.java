package com.douane.metier.utilisateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.douane.entite.Utilisateur;
import com.douane.repository.UtilisateurRepository;
@Service
public class UtilisateurImpl implements IUtilisateur{
	@Autowired
	private UtilisateurRepository utilRep;

	@Override
	public void updateUtilisateur(Utilisateur utilisateur, Long id) {
		String nom = utilisateur.getNom();
		String prenom = utilisateur.getPrenom();
		String matricule = utilisateur.getMatricule();
		String login = utilisateur.getLogin();
		String poste = utilisateur.getPoste();
		String password = utilisateur.getPassword();
		
		Utilisateur utilisateurs = utilRep.findById(id).get();
		
		utilisateurs.setNom(nom);
		utilisateurs.setPrenom(prenom);
		utilisateurs.setMatricule(matricule);
		utilisateurs.setLogin(login);
		utilisateurs.setPoste(poste);
		utilisateurs.setPassword(password);
		
		
		
	}

	@Override
	public void saveUtilisateur(Utilisateur utilisateur) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		utilisateur.setPassword(bcrypt.encode(utilisateur.getPassword()));
    	utilRep.save(utilisateur);
		utilRep.save(utilisateur);
		
	}

	@Override
	public void dellUtilisateur(Long id) {
		Utilisateur utilisateur = utilRep.findById(id).get();
		utilRep.delete(utilisateur);
		
	}

	@Override
	public List<Utilisateur> findAllUtilisateur() {
		return (List<Utilisateur>) utilRep.findAll();
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return utilRep.findByLogin(login);
	}

}
