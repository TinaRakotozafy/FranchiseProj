package com.douane;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import com.douane.entite.Client;
import com.douane.entite.Demande;
import com.douane.entite.FCuo;
import com.douane.entite.FDossier;
import com.douane.entite.FRequerant;
import com.douane.entite.FTypeFranchise;
import com.douane.entite.Marchandise;
import com.douane.entite.TraiterDemande;
import com.douane.metier.IDemande;
import com.douane.model.FEtatDemande;
import com.douane.repository.AttributionRepository;
import com.douane.repository.ClientRepository;
import com.douane.repository.DemandeRepository;
import com.douane.repository.FCuoRepository;
import com.douane.repository.FDossierRepository;
import com.douane.repository.FRequerantRepository;
import com.douane.repository.FTypeFranchiseRepository;
import com.douane.repository.MarchandiseRepository;*/

@SpringBootApplication//(scanBasePackages={"com.douane.metier.TypeFranchise.ITypeFranchise"})
public class Demo2Application /*implements CommandLineRunner*/{
	/*@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private FCuoRepository fcuoRepository;
	@Autowired
	private FDossierRepository fDossierRepository;
	@Autowired
	private FRequerantRepository fRequerantRepository;
	@Autowired
	private FTypeFranchiseRepository fTypeFranchiseRepository;
	@Autowired
	private MarchandiseRepository marchandiseRepository;
	/*@Autowired
	//private DemandeRepository demandeRepository;
	//@Autowired
	//private AttributionRepository attributionRepository;
	@Autowired
	private IDemande iDemande;*/
	
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		Client c1 = clientRepository.save(new Client("Tina", "Tina@gmail"));
		Client c2 = clientRepository.save(new Client("Tina1", "Tina1@gmail"));
		FCuo fcuo = fcuoRepository.save(new FCuo("sigleA", "A"));
		fcuoRepository.save(new FCuo("sigleB", "B"));
		FDossier fdossier = fDossierRepository.save(new FDossier("dossierA", "../document/classe", "dossier andramana voalohany", true));
		FDossier dossier2 = new FDossier("dossierB", "../document/classe", "dossier andramana faharoa", false);
		FRequerant frequerant =fRequerantRepository.save(new FRequerant("ceci est un renseignement", "anarana"));
		//FTypeFranchise ftype = fTypeFranchiseRepository.save(new FTypeFranchise("kaody26253", "ceci est un designation"));
		Marchandise marchandise = marchandiseRepository.save(new Marchandise("RangRov", "4*4"));
		//Demande demande = demandeRepository.save(new Demande(c1, ftype, new Date(), "bzjkffuh", fcuo, frequerant, fdossier, marchandise));
		//Demande demande2 = demandeRepository.save(new Demande(c1, ftype, new Date(), "aaaaaaaaa", fcuo, frequerant, fdossier, marchandise));
		//demandeRepository.delete(demande);
		//attributionRepository.save(new TraiterDemande(new Date(), demande, "Otrany tsy mety", "fangatahana", FEtatDemande.ACCEPTE, dossier2 ));
		//iDemande.traiter((long) 1, "Otrany mety", FEtatDemande.ACCEPTE, dossier2);
	}
*/
}
