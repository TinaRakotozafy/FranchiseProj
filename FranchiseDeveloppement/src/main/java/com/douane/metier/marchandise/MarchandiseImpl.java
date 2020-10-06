package com.douane.metier.marchandise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douane.entite.Marchandise;
import com.douane.repository.MarchandiseRepository;
@Service
public class MarchandiseImpl implements IMarchandise{
	@Autowired
	private MarchandiseRepository marchandiseRepository;
	@Override
	public void updateMarchandise(Marchandise marchandise, Long id) {
		String nom = marchandise.getNom();
		String description = marchandise.getDescription();
		
		Marchandise marchandises = marchandiseRepository.findById(id).get();
		
		marchandises.setNom(nom);
		marchandises.setDescription(description);

		marchandiseRepository.save(marchandises);
		
	}

	@Override
	public void saveMarchandise(Marchandise marchandise) {
		marchandiseRepository.save(marchandise);
		
	}

	@Override
	public void dellMarchandise(Long id) {
		Marchandise marchandise = marchandiseRepository.findById(id).get();
		marchandiseRepository.delete(marchandise);
		
	}

	@Override
	public List<Marchandise> findAllMarchandise() {
		
		return (List<Marchandise>) marchandiseRepository.findAll();
	}
	
}
