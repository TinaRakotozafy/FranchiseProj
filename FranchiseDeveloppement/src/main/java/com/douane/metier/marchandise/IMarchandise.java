package com.douane.metier.marchandise;

import java.util.List;

import com.douane.entite.Marchandise;

public interface IMarchandise {
	void updateMarchandise(Marchandise marchandise, Long id);
	void saveMarchandise(Marchandise marchandise);
	void dellMarchandise(Long id);
	List<Marchandise> findAllMarchandise();
}
