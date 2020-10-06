package com.douane.metier.requerant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.FRequerant;
import com.douane.repository.FRequerantRepository;

@Service
@Transactional
public class RequerantImpl implements IRequerant{
	@Autowired
	private FRequerantRepository requerantRepository;
	@Override
	public List<FRequerant> findAllRequerant(){
		return (List<FRequerant>)requerantRepository.findAll();
	}
	@Override
	public void saveRequerant(FRequerant requerant) {
		requerantRepository.save(requerant);
	}
	@Override
	public void dellRequerant(Long id) {
		FRequerant requerant1 = requerantRepository.findById(id).get();
		requerantRepository.delete(requerant1);
	}
	@Override
	public void updateRequerant(FRequerant requerant, Long id) {
		String nom = requerant.getNom();
		String renseignement = requerant.getRenseignement();
		FRequerant requerants = requerantRepository.findById(id).get();
		requerants.setNom(nom);
		requerants.setRenseignement(renseignement);
		
		requerantRepository.save(requerants);
	}
}
