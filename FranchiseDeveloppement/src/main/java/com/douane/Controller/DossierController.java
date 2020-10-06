package com.douane.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douane.entite.FDossier;
import com.douane.entite.FRequerant;
import com.douane.metier.Dossier.IDossier;
import com.douane.repository.FDossierRepository;
import com.douane.repository.FRequerantRepository;
@Controller
@RequestMapping("/dossiers/")
public class DossierController {
	@Autowired
	 private final FDossierRepository dossierRepository;
	 
	@Autowired
	private IDossier metierDossier;
	
	    @Autowired
	    public DossierController(FDossierRepository dossierRepository) {
	        this.dossierRepository = dossierRepository;
	    }

	    @GetMapping("signup")
	    public String showSignUpForm(FDossier dossier) {
	        return "addDossier";
	    }

	    @GetMapping("list")
	    public String showUpdateForm(Model model) {
	    	List<FDossier> dossiers = metierDossier.findAllDossier();
	        model.addAttribute("dossiers", dossiers);
	        return "dossier";
	    }

	    @PostMapping("add")
	    public String addDossier(@Validated FDossier dossier, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "addDossier";
	        }

	        metierDossier.saveDossier(dossier);
	        return "redirect:list";
	    }

	    @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	FDossier dossier = dossierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("dossier", dossier);
	        return "updateDossier";
	    }

	    @PostMapping("update/{id}")
	    public String updateDossier(@PathVariable("id") long id, @Validated FDossier dossier, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            dossier.setIdDossier(id);
	            return "updateDossier";
	        }

	        metierDossier.saveDossier(dossier);
	        model.addAttribute("dossiers", metierDossier.findAllDossier());
	        return "dossier";
	    }

	    @GetMapping("delete/{id}")
	    public String deleteDossier(@PathVariable("id") long id, Model model) {
	    	metierDossier.dellDossier(id);
	        model.addAttribute("dossiers", metierDossier.findAllDossier());
	        return "dossier";
	    }
}
