package com.douane.metier.TypeFranchise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.FTypeFranchise;
import com.douane.repository.FTypeFranchiseRepository;

@Service
@Transactional
public class TypeFranchiseImpl implements ITypeFranchise{
	@Autowired
	private FTypeFranchiseRepository typeFranchiseRepository;

	@Override
	public void updateTypeFranchise(FTypeFranchise typeFranchise, Long id) {
		String code = typeFranchise.getCode();
		String designation = typeFranchise.getDesignation();
		FTypeFranchise typeFranchises = typeFranchiseRepository.findById(id).get();
		typeFranchises.setCode(code);
		typeFranchises.setDesignation(designation);
		
		typeFranchiseRepository.save(typeFranchises);
		
	}

	@Override
	public void saveTypeFranchise(FTypeFranchise typeFranchise) {
		typeFranchiseRepository.save(typeFranchise);
		
	}

	@Override
	public void dellTypeFranchise(Long id) {
		FTypeFranchise typeFranchise1 = typeFranchiseRepository.findById(id).get();
		typeFranchiseRepository.delete(typeFranchise1);
		
	}

	@Override
	public List<FTypeFranchise> findAllTypeFranchise() {
		return (List<FTypeFranchise>)typeFranchiseRepository.findAll();
	
	}
	
}
