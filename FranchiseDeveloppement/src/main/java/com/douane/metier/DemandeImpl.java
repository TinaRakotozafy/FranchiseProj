package com.douane.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.Agent;
import com.douane.entite.AttribuDemande;
import com.douane.entite.Demande;
import com.douane.entite.FCuo;
import com.douane.entite.FDossier;
import com.douane.entite.FRequerant;
import com.douane.entite.FTypeFranchise;
import com.douane.entite.Marchandise;
import com.douane.entite.TraiterDemande;
import com.douane.model.FEtatDemande;
import com.douane.repository.AttributionRepository;
import com.douane.repository.DemandeRepository;

@Service
@Transactional
public class DemandeImpl implements IDemande {
	@Autowired
	private DemandeRepository demandeRepository;
	@Autowired
	private AttributionRepository attributionRepository;
	
	@Override
	public Demande consulterDemande(Long numeroDemande) {
		
		return demandeRepository.findById(numeroDemande).get();
		//return null;
	}

	@Override
	public void traiter(Long numeroDemande, String observation, FEtatDemande etatDemande, FDossier dossier,Agent agentDetenteur, Agent agentReceveur, boolean presence) {
		Demande demande = consulterDemande(numeroDemande);
		TraiterDemande traitement = new TraiterDemande(demande, observation,
				etatDemande, dossier, agentDetenteur, agentReceveur, presence);
		attributionRepository.save(traitement);
		demande.setEtatDemande(etatDemande);
		demande.setDossier(demande.getDossier());
		demandeRepository.save(demande);
	}

	@Override
	public Page<AttribuDemande> listeAttribuDemande(Long numeroDemande, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		return attributionRepository.listeAttributionDemande(numeroDemande, pageRequest);
	}
	@Override
	public void maj(AttribuDemande attributionDemande) {
		Demande demande = attributionDemande.getDemande();
		/*Agent agentReceveur = attributionDemande.getAgentReceveur();
		Agent agentDetenteur = attributionDemande.getAgentDetenteur();*/
		FEtatDemande etatDemande = attributionDemande.getEtatDemande();
		boolean presence = attributionDemande.isPresence();
		demande.setEtatDemande(etatDemande);
		//demande.setAgent(agent);
		demande.setPresence(presence);
	}

	@Override
	public void updateDemande(Demande demande, Long id) {
		FTypeFranchise selectType = demande.getTypeFranchise();
    	FCuo selectCuo = demande.getFcuo();
    	FRequerant selectRequerant = demande.getFrequerant();
    	FDossier selectDossier = demande.getDossier();
    	Marchandise selectMarchandise = demande.getMarchandise();
    	
    	Demande demande1 = demandeRepository.findById(id).get();
    	
    	demande1.setTypeFranchise(selectType);
    	demande1.setFcuo(selectCuo);
    	demande1.setFrequerant(selectRequerant);
    	demande1.setDossier(selectDossier);
    	demande1.setMarchandise(selectMarchandise);
    	
    	demandeRepository.save(demande1);
		
	}

	@Override
	public void saveDemande(Demande demande) {
		demandeRepository.save(demande);
		
	}

	@Override
	public void dellDemande(Long id) {
		Demande demande = demandeRepository.findById(id).get();
		demandeRepository.delete(demande);
		
	}

	@Override
	public List<Demande> findAllDemande() {
		
		return (List<Demande>) demandeRepository.findAll();
	}
	
	

}
