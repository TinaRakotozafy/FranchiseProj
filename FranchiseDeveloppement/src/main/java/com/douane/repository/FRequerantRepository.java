package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.douane.entite.FCuo;
import com.douane.entite.FRequerant;

public interface FRequerantRepository extends CrudRepository<FRequerant, Long>{
	public List<FRequerant> findAll();
}
