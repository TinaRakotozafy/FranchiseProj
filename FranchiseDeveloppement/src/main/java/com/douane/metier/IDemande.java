package com.douane.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.douane.entite.Agent;
import com.douane.entite.AttribuDemande;
import com.douane.entite.Demande;
import com.douane.entite.FDossier;
import com.douane.model.FEtatDemande;

public interface IDemande {
	public Demande consulterDemande(Long numeroDemande);
	public void traiter(Long i,String observation, FEtatDemande etatDemande, FDossier dossier,Agent agentDetenteur, Agent agentReceveur, boolean presence);
	public Page<AttribuDemande> listeAttribuDemande(Long numeroDemande, int page, int size);
	public void maj(AttribuDemande attributionDemande);
	
	void updateDemande(Demande demande, Long id);
	void saveDemande(Demande demande);
	void dellDemande(Long id);
	List<Demande> findAllDemande();
}
