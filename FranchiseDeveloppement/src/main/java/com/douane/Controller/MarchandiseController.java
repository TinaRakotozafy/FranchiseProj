package com.douane.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douane.entite.FCuo;
import com.douane.entite.Marchandise;
import com.douane.metier.marchandise.IMarchandise;
import com.douane.repository.FCuoRepository;
import com.douane.repository.MarchandiseRepository;

@Controller
@RequestMapping("/marchandises/")
public class MarchandiseController {
	@Autowired
	private IMarchandise marchandiseMet;
	private final MarchandiseRepository marchandiseRepository;

    @Autowired
    public MarchandiseController(MarchandiseRepository marchandiseRepository) {
        this.marchandiseRepository = marchandiseRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Marchandise marchandise) {
        return "addMarchandise";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("marchandises", marchandiseRepository.findAll());
        return "marchandise";
    }

    @PostMapping("add")
    public String addMarchandise(@Validated Marchandise marchandise, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addMarchandise";
        }
        marchandiseMet.saveMarchandise(marchandise);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	Marchandise marchandise = marchandiseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("marchandise", marchandise);
        return "updateMarchandise";
    }

    @PostMapping("update/{id}")
    public String updateMarchandise(@PathVariable("id") long id, @Validated Marchandise marchandise, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            marchandise.setIdMarchandise(id);
            return "updateMarchandise";
        }
        marchandiseMet.updateMarchandise(marchandise, id);
        model.addAttribute("marchandises", marchandiseMet.findAllMarchandise());
        return "marchandise";
    }

    @GetMapping("delete/{id}")
    public String deleteMarchandise(@PathVariable("id") long id, Model model) {
    	marchandiseMet.dellMarchandise(id);
        model.addAttribute("marchandises", marchandiseMet.findAllMarchandise());
        return "marchandise";
    }
}
