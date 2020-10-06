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
import com.douane.entite.Role;
import com.douane.entite.Utilisateur;
import com.douane.metier.IDemande;
import com.douane.metier.Agent.IAgent;
import com.douane.metier.Role.IRole;
import com.douane.model.FEtatDemande;
import com.douane.repository.AgentRepository;
import com.douane.repository.AttributionRepository;
import com.douane.repository.DemandeRepository;
import com.douane.repository.FDossierRepository;
import com.douane.repository.UtilisateurRepository;
@Controller
@RequestMapping("/utilisateurs/")
public class UtilisateurController {
	@Autowired
	private UtilisateurRepository utilRep;
	@Autowired
	private IRole roleMet;

    @GetMapping("signup")
    public String showSignUpForm(Utilisateur utilisateur, Model model) {
    	List<Role> selectRoles = new ArrayList<>();
    	selectRoles = roleMet.findAllRole();
        model.addAttribute("selectRoles", selectRoles);
    	return "addUtilisateur";
    }
    @GetMapping("list")
    public String showUpdateForm(Utilisateur utilisateur, Model model) {
        model.addAttribute("utilisateurs", utilRep.findAll());
        return "utilisateur";
    }
    
    @PostMapping("add")
    public String addAttribution(@Validated Utilisateur utilisateur, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            return "attribuDemande";
        }
    	utilRep.save(utilisateur);
    	
        return "redirect:list";
    }
 
    /*
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
*/
    @GetMapping("delete/{id}")
    public String deleteAttribution(@PathVariable("id") long id, Model model) {
    	Utilisateur utilisateur = utilRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    	utilRep.delete(utilisateur);
        model.addAttribute("utilisateurs", utilRep.findAll());
        return "utilisateur";
    }
}
