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

import com.douane.entite.Agent;
import com.douane.metier.Agent.IAgent;
import com.douane.repository.AgentRepository;
@Controller
@RequestMapping("/agents/")
public class AgentController {
	 private final AgentRepository agentRepository;
	 @Autowired
	 private IAgent agentMetier;

	    @Autowired
	    public AgentController(AgentRepository agentRepository) {
	        this.agentRepository = agentRepository;
	    }

	    @GetMapping("signup")
	    public String showSignUpForm(Agent agent) {
	        return "addAgent";
	    }

	    @GetMapping("list")
	    public String showUpdateForm(Model model) {
	        model.addAttribute("agents", agentMetier.findAllAgent());
	        return "agent";
	    }

	    @PostMapping("add")
	    public String addAgent(@Validated Agent agent, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "addAgent";
	        }
	        agentMetier.saveAgent(agent);
	        return "redirect:list";
	    }

	    @GetMapping("edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	    	Agent agent = agentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	        model.addAttribute("agent", agent);
	        return "updateAgent";
	    }

	    @PostMapping("update/{id}")
	    public String updateAgent(@PathVariable("id") long id, @Validated Agent agent, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            agent.setIdAgent(id);
	            return "updateAgent";
	        }

	        agentMetier.updateAgent(agent, id);
	        model.addAttribute("agents", agentMetier.findAllAgent());
	        return "agent";
	    }

	    @GetMapping("delete/{id}")
	    public String deleteAgent(@PathVariable("id") long id, Model model) {
	    	agentMetier.dellAgent(id);
	        model.addAttribute("agents", agentMetier.findAllAgent());
	        return "agent";
	    }
}
