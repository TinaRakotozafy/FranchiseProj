package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.FRequerant;
import com.douane.entite.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	public List<Role> findAll();
}
