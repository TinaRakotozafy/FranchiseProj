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
import com.douane.entite.FRequerant;
import com.douane.metier.cuo.ICuo;
import com.douane.repository.FCuoRepository;
import com.douane.repository.FRequerantRepository;
@Controller
@RequestMapping("/cuos/")
public class TypeCuoController {
	private final FCuoRepository cuoRepository;
	@Autowired
	private ICuo metierCuo;

    @Autowired
    public TypeCuoController(FCuoRepository cuoRepository) {
        this.cuoRepository = cuoRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(FCuo cuo) {
        return "addCuo";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("cuos", metierCuo.findAllCuo());
        return "cuo";
    }

    @PostMapping("add")
    public String addCuo(@Validated FCuo cuo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCuo";
        }
        metierCuo.saveCuo(cuo);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
    	FCuo cuo = cuoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("cuo", cuo);
        return "updateCuo";
    }

    @PostMapping("update/{id}")
    public String updateCuo(@PathVariable("id") long id, @Validated FCuo cuo, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            cuo.setIdCuo(id);
            return "updateCuo";
        }
        metierCuo.updateCuo(cuo, id);
        model.addAttribute("cuos", metierCuo.findAllCuo());
        return "cuo";
    }

    @GetMapping("delete/{id}")
    public String deleteCuo(@PathVariable("id") long id, Model model) {
    	metierCuo.dellCuo(id);
        model.addAttribute("cuos", metierCuo.findAllCuo());
        return "cuo";
    }

}
