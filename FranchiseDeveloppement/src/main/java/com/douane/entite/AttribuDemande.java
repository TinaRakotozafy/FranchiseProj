package com.douane.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.douane.model.FEtatDemande;
@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class AttribuDemande implements Serializable{
	@Id
	@SequenceGenerator (name = "generatorAttribution", sequenceName = "AT_SEQ", allocationSize = 1) 
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generatorAttribution")
	private Long idAttribution;
	
	@ManyToOne
	@JoinColumn(name="idAgentD")
	private Agent agentDetenteur;
	
	@ManyToOne
	@JoinColumn(name="idAgentR")
	private Agent agentReceveur;
	
	private String observation;
	
	private FDossier dossier;
	
	private boolean presence;
	
	@Enumerated(EnumType.STRING)
	private FEtatDemande etatDemande;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateop")
	protected Date date=new Date();
	
	
	/*@Temporal(TemporalType.TIME)
	@Column(name="timeAttribution")
	protected Date time;*/
	
	@ManyToOne
	@JoinColumn(name="IdDemande")
	private Demande demande;
	public AttribuDemande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AttribuDemande(Demande demande, String observation, FEtatDemande etatDemande, FDossier dossier, Agent agentDetenteur, Agent agentReceveur, boolean presence) {
		super();
		//this.date = new Date();
		this.demande = demande;
		this.observation = observation;
		this.etatDemande = etatDemande;
		this.dossier = dossier;
		this.agentDetenteur = agentDetenteur;
		this.agentReceveur = agentReceveur;
		this.presence = presence;
	}
	
	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	

	/*public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}*/

	public Agent getAgentDetenteur() {
		return agentDetenteur;
	}

	public void setAgentDetenteur(Agent agentDetenteur) {
		this.agentDetenteur = agentDetenteur;
	}

	public Agent getAgentReceveur() {
		return agentReceveur;
	}

	public void setAgentReceveur(Agent agentReceveur) {
		this.agentReceveur = agentReceveur;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Long getId() {
		return idAttribution;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public FDossier getDossier() {
		return dossier;
	}

	public void setDossier(FDossier dossier) {
		this.dossier = dossier;
	}

	public FEtatDemande getEtatDemande() {
		return etatDemande;
	}

	public void setEtatDemande(FEtatDemande etatDemande) {
		this.etatDemande = etatDemande;
	}

	public Long getIdAttribution() {
		return idAttribution;
	}

	public void setIdAttribution(Long idAttribution) {
		this.idAttribution = idAttribution;
	}
	
}
