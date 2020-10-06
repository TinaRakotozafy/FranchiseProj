package com.douane.metier.Dossier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.FDossier;
import com.douane.repository.FDossierRepository;

@Service
@Transactional
public class DossierImpl implements IDossier{
	@Autowired
	private FDossierRepository dossierRepository;

	@Override
	public void updateDossier(FDossier dossier, Long id) {
		String nom = dossier.getNom();
		String path = dossier.getPath();
		String description = dossier.getDescription();
		boolean presence = false;
		
		FDossier dossiers = dossierRepository.findById(id).get();
		
		dossiers.setNom(nom);
		dossiers.setDescription(description);
		dossiers.setPath(path);
		dossiers.setPresence(presence);
	
		dossierRepository.save(dossiers);
		
	}

	@Override
	public void saveDossier(FDossier dossier) {
		dossierRepository.save(dossier);
		
	}

	@Override
	public void dellDossier(Long id) {
		FDossier dossier1 = dossierRepository.findById(id).get();
		dossierRepository.delete(dossier1);
		
	}

	@Override
	public List<FDossier> findAllDossier() {
		return (List<FDossier>)dossierRepository.findAll();
	}
	
}
