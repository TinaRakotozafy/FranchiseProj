package com.douane.metier.Agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douane.entite.Agent;
import com.douane.repository.AgentRepository;

@Service
public class AgentImpl implements IAgent {
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public void updateAgent(Agent agent, Long id) {
		String nom = agent.getNom();
		String role = agent.getRole();
		
		Agent agent1 = agentRepository.findById(id).get();
		
		agent1.setNom(nom);
		agent1.setRole(role);

		agentRepository.save(agent1);
		
	}

	@Override
	public void saveAgent(Agent agent) {
		agentRepository.save(agent);
	}

	@Override
	public void dellAgent(Long id) {
		Agent agent = agentRepository.findById(id).get();
		agentRepository.delete(agent);
		
	}

	@Override
	public List<Agent> findAllAgent() {
		
		return (List<Agent>) agentRepository.findAll();
	}
	
}
