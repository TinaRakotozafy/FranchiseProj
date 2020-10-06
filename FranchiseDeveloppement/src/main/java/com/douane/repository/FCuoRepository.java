package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.FCuo;
import com.douane.entite.FTypeFranchise;

public interface FCuoRepository extends CrudRepository<FCuo, Long>{
	public List<FCuo> findAll();
}
