package com.douane.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douane.entite.Agent;
import com.douane.entite.Demande;
import com.douane.entite.FCuo;
import com.douane.entite.FDossier;
import com.douane.entite.FRequerant;
import com.douane.entite.FTypeFranchise;
import com.douane.entite.Marchandise;
import com.douane.metier.IDemande;
import com.douane.metier.Dossier.IDossier;
import com.douane.metier.TypeFranchise.ITypeFranchise;
import com.douane.metier.cuo.ICuo;
import com.douane.metier.marchandise.IMarchandise;
import com.douane.metier.requerant.IRequerant;
import com.douane.repository.AgentRepository;
import com.douane.repository.DemandeRepository;
import com.douane.repository.FCuoRepository;
import com.douane.repository.FDossierRepository;
import com.douane.repository.FRequerantRepository;
import com.douane.repository.FTypeFranchiseRepository;
import com.douane.repository.MarchandiseRepository;

@Controller
@RequestMapping("/demandes/")
public class DemandeController {
	@Autowired
	private IDemande demandeMetier;
	@Autowired
	private ITypeFranchise typeFranchiseMet;
	@Autowired
	private ICuo cuoMetier;
	@Autowired
	private IRequerant requerantMetier;
	@Autowired
	private IDossier dossierMetier;
	@Autowired
	private IMarchandise marchandiseMet;
	@Autowired
	private FTypeFranchiseRepository typeFranchiseRepository;
	@Autowired 
	private FCuoRepository cuoRepository;
	@Autowired
	private FRequerantRepository requerantRepository;
	@Autowired
	private FDossierRepository dossierRepository;
	@Autowired
	private MarchandiseRepository marchandiseRepository;
	@Autowired
	private DemandeRepository demandeRepository;

    @Autowired
    public DemandeController(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Demande demande, Model model, @ModelAttribute("selectType") FTypeFranchise selectType, @ModelAttribute("selectType") FCuo selectCuo, @ModelAttribute("selectType") FRequerant selectRequerant, @ModelAttribute("selectType") FDossier selectDossier, @ModelAttribute("selectType") Marchandise selectMarchandise) {
    	List<FTypeFranchise> selectTypes = new ArrayList<>();
    	List<FCuo> selectCuos = new ArrayList<>();
    	List<FRequerant> selectRequerants = new ArrayList<>();
    	List<FDossier> selectDossiers = new ArrayList<>();
    	List<Marchandise> selectMarchandises = new ArrayList<>();
    	
    	selectMarchandises = marchandiseMet.findAllMarchandise();//marchandiseRepository.findAll();
    	selectDossiers = dossierMetier.findAllDossier();//dossierRepository.findAll();
    	selectRequerants = requerantMetier.findAllRequerant();//requerantRepository.findAll();
    	selectCuos = cuoMetier.findAllCuo();//cuoRepository.findAll();
    	selectTypes = typeFranchiseMet.findAllTypeFranchise();//typeFranchiseRepository.findAll();
    	
    	model.addAttribute("selectRequerants", selectRequerants);
    	model.addAttribute("selectCuos", selectCuos);
    	model.addAttribute("selectTypes", selectTypes);
    	model.addAttribute("selectDossiers", selectDossiers);
    	model.addAttribute("selectMarchandises", selectMarchandises);
    	return "addDemande";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
    	List<Demande> demande = demandeMetier.findAllDemande();
        model.addAttribute("demandes", demande);
        return "demande";
    }

    @RequestMapping("/list_order")
    public String showUpdateFormOrder(Model model, String order) {
    	if(order.equals("requerant"))
    	{
    		List<Demande> demande = demandeMetier.findAllSortByRequerant();
            model.addAttribute("demandes", demande);
    	}
    	else if(order.equals("bureau"))
    	{
    		List<Demande> demande = demandeMetier.findAllSortByBureau();
            model.addAttribute("demandes", demande);
    	}
    	else if(order.equals("etat"))
    	{
    		List<Demande> demande = demandeMetier.findAllSorByEtatDemande();
            model.addAttribute("demandes", demande);
    	}
    	else if(order.equals("date"))
    	{
    		List<Demande> demande = demandeMetier.findAllSorByDateDemande();
            model.addAttribute("demandes", demande);
    	}
        return "demande";
    }
    
    @PostMapping("add")
    public String addDemande(@Validated Demande demande, BindingResult result, Model model, @ModelAttribute("selectType") FTypeFranchise selectType, @ModelAttribute("selectType") FCuo selectCuo) {
    	
        if (result.hasErrors()) {
            return "demande";
        }
        demandeRepository.save(demande);
        return "redirect:list";
    }
 

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Demande demande = demandeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("demande", demande);
        List<FTypeFranchise> selectTypes = new ArrayList<>();
    	List<FCuo> selectCuos = new ArrayList<>();
    	List<FRequerant> selectRequerants = new ArrayList<>();
    	List<FDossier> selectDossiers = new ArrayList<>();
    	List<Marchandise> selectMarchandises = new ArrayList<>();
    	
    	selectMarchandises = marchandiseMet.findAllMarchandise();//marchandiseRepository.findAll();
    	selectDossiers = dossierMetier.findAllDossier();//dossierRepository.findAll();
    	selectRequerants = requerantMetier.findAllRequerant();//requerantRepository.findAll();
    	selectCuos = cuoMetier.findAllCuo();//cuoRepository.findAll();
    	selectTypes = typeFranchiseMet.findAllTypeFranchise();//typeFranchiseRepository.findAll();
    	
    	model.addAttribute("selectRequerants", selectRequerants);
    	model.addAttribute("selectCuos", selectCuos);
    	model.addAttribute("selectTypes", selectTypes);
    	model.addAttribute("selectDossiers", selectDossiers);
    	model.addAttribute("selectMarchandises", selectMarchandises);
        return "updatedemande";
    }

    @PostMapping("update/{id}")
    public String updateDemande(@PathVariable("id") long id, @Validated Demande demande, BindingResult result,
        Model model, @ModelAttribute("selectType") FTypeFranchise selectType, @ModelAttribute("selectType") FCuo selectCuo, @ModelAttribute("selectType") FRequerant selectRequerant, @ModelAttribute("selectType") FDossier selectDossier, @ModelAttribute("selectType") Marchandise selectMarchandise) {
        if (result.hasErrors()) {
            demande.setNumeroDemande(id);
            return "updatedemande";
        }
    	
    	demandeMetier.updateDemande(demande, id);
    	
        model.addAttribute("demandes", demandeMetier.findAllDemande());
        return "demande";
    }

    @GetMapping("delete/{id}")
    public String deleteDemande(@PathVariable("id") long id, Model model) {
    	demandeMetier.dellDemande(id);
        model.addAttribute("demandes", demandeMetier.findAllDemande());
        return "demande";
    }
}
