package com.douane.metier.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douane.entite.Role;
import com.douane.repository.RoleRepository;
@Service
public class RoleImpl implements IRole{
	@Autowired
	private RoleRepository roleRep;
	@Override
	public List<Role> findAllRole() {
		return (List<Role>)roleRep.findAll();
	}

}
