package com.douane.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@GetMapping("")
    public String homePage() {
        return "index";
    }
	/*
    @GetMapping("/requerant")
    public String requerantPage() {
        return "requerant";
    }

    @GetMapping("/typeFranchise")
    public String typeFranchisePage() {
        return "typeFranchise";
    }
    @GetMapping("/dossier")
    public String dossierPage() {
        return "dossier";
    }
    @GetMapping("/cuo")
    public String cuoPage() {
        return "cuo";
    }
    @GetMapping("/marchandise")
    public String marchandisePage() {
        return "marchandise";
    }
    @GetMapping("/demande")
    public String demandePage() {
        return "demande";
    }
    @GetMapping("/agent")
    public String agentPage() {
        return "agent";
    }
    @GetMapping("/attribuDemande")
    public String attributionPage() {
        return "attribuDemande";
    }*/
    
}
