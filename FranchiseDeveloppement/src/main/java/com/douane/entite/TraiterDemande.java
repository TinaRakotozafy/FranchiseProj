package com.douane.entite;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.douane.model.FEtatDemande;
@Entity
@DiscriminatorValue("D")
public class TraiterDemande extends AttribuDemande{

	public TraiterDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TraiterDemande(Demande demande, String observation, FEtatDemande etatDemande, FDossier dossier,
			Agent agentDetenteur, Agent agentReceveur, boolean presence) {
		super(demande, observation, etatDemande, dossier, agentDetenteur, agentReceveur, presence);
		// TODO Auto-generated constructor stub
	}
	
}
