package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Marchandise;

public interface MarchandiseRepository extends CrudRepository<Marchandise, Long>{
	public List<Marchandise> findAll();
}
