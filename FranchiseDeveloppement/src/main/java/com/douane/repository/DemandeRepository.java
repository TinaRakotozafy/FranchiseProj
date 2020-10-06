package com.douane.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Demande;

public interface DemandeRepository extends CrudRepository<Demande, Long>{
	public List<Demande> findAll();
}
