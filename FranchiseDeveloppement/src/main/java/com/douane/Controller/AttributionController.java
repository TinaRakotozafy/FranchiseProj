package com.douane.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douane.entite.Agent;
import com.douane.entite.AttribuDemande;
import com.douane.entite.Demande;
import com.douane.entite.FDossier;
import com.douane.entite.Marchandise;
import com.douane.metier.IDemande;
import com.douane.metier.Agent.IAgent;
import com.douane.model.FEtatDemande;
import com.douane.repository.AgentRepository;
import com.douane.repository.AttributionRepository;
import com.douane.repository.DemandeRepository;
import com.douane.repository.FDossierRepository;
@Controller
@RequestMapping("/attributions/")
public class AttributionController {
	@Autowired
	private IAgent agentMetier;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private IDemande demandeMetier;
	@Autowired
	private AttributionRepository attributionRepository;
	
	@Autowired
	private FDossierRepository dossierRepository;

	@Autowired
	private DemandeRepository demandeRepository;

    @Autowired
    public AttributionController(AttributionRepository attributionRepository) {
        this.attributionRepository = attributionRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(AttribuDemande attributionDemande, Model model, @ModelAttribute("selectDemande") Demande selectDemande) {
    	List<Demande> selectDemandes = new ArrayList<>();
    	List<Agent> selectAgents = new ArrayList<>();
        selectDemandes = demandeMetier.findAllDemande();
        selectAgents = agentMetier.findAllAgent();
        model.addAttribute("selectDemandes", selectDemandes);
        model.addAttribute("selectAgents", selectAgents);
    	return "addAttribution";
    }
    @RequestMapping("/consulterDemande")
    public String consulter(Model model, Long numeroDemande) {
    	model.addAttribute("numeroDemande", numeroDemande);
    	try {
    		Demande demande = demandeMetier.consulterDemande(numeroDemande);
    		Page<AttribuDemande> pageAttributions = demandeMetier.listeAttribuDemande(numeroDemande, 0, 4);
    		model.addAttribute("listeAttributions", pageAttributions.getContent());
        	model.addAttribute("demande", demande);
    	}catch(Exception e) {
    		model.addAttribute("exception", e);
    	}
    	
        return "attribuDemande";
    }
    @GetMapping("list")
    public String showUpdateForm(AttribuDemande attributionDemande, Model model) {
        model.addAttribute("attributions", attributionRepository.findAll());
        return "attribuDemande";
    }

    @PostMapping("add")
    public String addAttribution(@Validated AttribuDemande attributionDemande, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            return "attribuDemande";
        }
    	//demandeMetier.maj(attributionDemande);
    	attributionRepository.save(attributionDemande);
    	
        return "redirect:list";
    }
 

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	AttribuDemande attributionDemande = attributionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("attributionDemande", attributionDemande);
        return "updateAttribution";
    }

    @PostMapping("update/{id}")
    public String updateAttribution(@PathVariable("id") long id, @Validated AttribuDemande attributionDemande, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            attributionDemande.setIdAttribution(id);
            return "updateAttribution";
        }
        
        attributionRepository.save(attributionDemande);
        model.addAttribute("attributions", attributionRepository.findAll());
        return "attribuDemande";
    }

    @GetMapping("delete/{id}")
    public String deleteAttribution(@PathVariable("id") long id, Model model) {
    	AttribuDemande attributionDemande = attributionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    	attributionRepository.delete(attributionDemande);
        model.addAttribute("attributionDemandes", attributionRepository.findAll());
        return "attribuDemande";
    }
}
