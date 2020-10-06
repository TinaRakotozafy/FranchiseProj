package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.FTypeFranchise;

public interface FTypeFranchiseRepository extends CrudRepository<FTypeFranchise, Long>{
	public List<FTypeFranchise> findAll();
}
