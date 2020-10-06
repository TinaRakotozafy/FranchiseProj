package com.douane.metier.Dossier;

import java.util.List;

import com.douane.entite.FDossier;

public interface IDossier {
	void updateDossier(FDossier dossier, Long id);
	void saveDossier(FDossier dossier);
	void dellDossier(Long id);
	List<FDossier> findAllDossier();
}
