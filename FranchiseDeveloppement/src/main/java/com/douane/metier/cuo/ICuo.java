package com.douane.metier.cuo;

import java.util.List;

import com.douane.entite.FCuo;

public interface ICuo {
	void updateCuo(FCuo cuo, Long id);
	void saveCuo(FCuo cuo);
	void dellCuo(Long id);
	List<FCuo> findAllCuo();
}
