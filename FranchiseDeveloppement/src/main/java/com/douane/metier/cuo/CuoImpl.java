package com.douane.metier.cuo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entite.FCuo;
import com.douane.repository.FCuoRepository;

@Service
@Transactional
public class CuoImpl implements ICuo{
	@Autowired
	private FCuoRepository cuoRepository;

	@Override
	public void updateCuo(FCuo cuo, Long id) {
		String nom = cuo.getNom();
		String sigle = cuo.getSigle();
		FCuo cuo1 = cuoRepository.findById(id).get();
		cuo1.setNom(nom);
		cuo1.setSigle(sigle);
		
		cuoRepository.save(cuo1);
		
	}

	@Override
	public void saveCuo(FCuo cuo) {
		cuoRepository.save(cuo);
		
	}

	@Override
	public void dellCuo(Long id) {
		FCuo cuo1 = cuoRepository.findById(id).get();
		cuoRepository.delete(cuo1);
		
	}

	@Override
	public List<FCuo> findAllCuo() {
		return (List<FCuo>)cuoRepository.findAll();
	}
	
}
