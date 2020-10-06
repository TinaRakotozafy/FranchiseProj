package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.FDossier;

public interface FDossierRepository extends CrudRepository<FDossier, Long>{
	public List<FDossier> findAll();
}
