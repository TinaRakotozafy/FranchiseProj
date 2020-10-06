package com.douane.metier.Agent;

import java.util.List;

import com.douane.entite.Agent;

public interface IAgent {
	void updateAgent(Agent agent, Long id);
	void saveAgent(Agent agent);
	void dellAgent(Long id);
	List<Agent> findAllAgent();
}
