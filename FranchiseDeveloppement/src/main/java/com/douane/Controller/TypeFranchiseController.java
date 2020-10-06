package com.douane.Controller;

import java.util.ArrayList;
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

import com.douane.entite.FRequerant;
import com.douane.entite.FTypeFranchise;
import com.douane.metier.TypeFranchise.ITypeFranchise;
import com.douane.repository.FRequerantRepository;
import com.douane.repository.FTypeFranchiseRepository;

@Controller
@RequestMapping("/typeFranchises/")
public class TypeFranchiseController {
	@Autowired
	private ITypeFranchise metierTypeFranchise;
	@Autowired
	 private final FTypeFranchiseRepository typeFranchiseRepository;

	    @Autowired
	    public TypeFranchiseController(FTypeFranchiseRepository typeFranchiseRepository) {
	        this.typeFranchiseRepository = typeFranchiseRepository;
	    }

	    @GetMapping("signup")
	    public String showSignUpForm(FTypeFranchise typeFranchise) {
	        return "addTypeFranchise";
	    }

	    @GetMapping("list")
	    public String showUpdateForm(Model model) {
	    	List<FTypeFranchise> typeFranchises = metierTypeFranchise.findAllTypeFranchise();
	        model.addAttribute("typeFranchises", typeFranchises);
	        return "typeFranchise";
	    }

	    @PostMapping("add")
	    public String addTypeFranchise(@Validated FTypeFranchise typeFranchise, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "addTypeFranchise";
	        }

	        metierTypeFranchise.saveTypeFranchise(typeFranchise);
	        return "redirect:list";
	    }

	    @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	FTypeFranchise typeFranchise = typeFranchiseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("typeFranchise", typeFranchise);
	        return "updateTypeFranchise";
	    }

	    @PostMapping("update/{id}")
	    public String updateTypeFranchise(@PathVariable("id") long id, @Validated FTypeFranchise typeFranchise, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	        	typeFranchise.setIdType(id);
	            return "updateTypeFranchise";
	        }

	        metierTypeFranchise.updateTypeFranchise(typeFranchise, id);
	        model.addAttribute("typeFranchises", metierTypeFranchise.findAllTypeFranchise());
	        return "typeFranchise";
	    }

	    @GetMapping("delete/{id}")
	    public String deleteTypeFranchise(@PathVariable("id") long id, Model model) {
	    	metierTypeFranchise.dellTypeFranchise(id);
	    	List<FTypeFranchise> typeFranchises = metierTypeFranchise.findAllTypeFranchise();
	        model.addAttribute("typeFranchises", typeFranchises);
	        return "typeFranchise";
	    }
}
