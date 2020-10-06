package com.douane.metier.TypeFranchise;

import java.util.List;

import com.douane.entite.FTypeFranchise;


public interface ITypeFranchise {
	void updateTypeFranchise(FTypeFranchise typeFranchise, Long id);
	void saveTypeFranchise(FTypeFranchise typeFranchise);
	void dellTypeFranchise(Long id);
	List<FTypeFranchise> findAllTypeFranchise();
}
