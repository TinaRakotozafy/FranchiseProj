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

import com.douane.entite.FRequerant;
import com.douane.metier.requerant.IRequerant;
import com.douane.repository.FRequerantRepository;
@Controller
@RequestMapping("/requerants/")
public class RequerantController {
		@Autowired
		private IRequerant metierRequerant;
		@Autowired
	    private final FRequerantRepository requerantRepository;

	    @Autowired
	    public RequerantController(FRequerantRepository requerantRepository) {
	        this.requerantRepository = requerantRepository;
	    }

	    @GetMapping("signup")
	    public String showSignUpForm(FRequerant requerant) {
	        return "add-requerant";
	    }

	    @GetMapping("list")
	    public String showUpdateForm(Model model) {
	    	List<FRequerant> requerants = metierRequerant.findAllRequerant();
	        model.addAttribute("requerants", requerants);
	        return "requerant";
	    }

	    @PostMapping("add")
	    public String addRequerant(@Validated FRequerant requerant, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-requerant";
	        }
	        metierRequerant.saveRequerant(requerant);
	        return "redirect:list";
	    }

	    @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	FRequerant requerant = requerantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("requerant", requerant);
	        return "update-requerant";
	    }

	    @PostMapping("update/{id}")
	    public String updateRequerant(@PathVariable("id") long id, @Validated FRequerant requerant, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            requerant.setIdRequerant(id);
	            return "update-requerant";
	        }
	        metierRequerant.updateRequerant(requerant, id);
	        model.addAttribute("requerants", metierRequerant.findAllRequerant());
	        return "requerant";
	    }

	    @GetMapping("delete/{id}")
	    public String deleteRequerant(@PathVariable("id") long id, Model model) {
	    	metierRequerant.dellRequerant(id);
	    	List<FRequerant> requerants = metierRequerant.findAllRequerant();
	        model.addAttribute("requerants", requerants);
	        return "requerant";
	    }
	
}
