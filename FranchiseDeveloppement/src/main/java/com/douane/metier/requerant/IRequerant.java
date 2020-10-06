package com.douane.metier.requerant;

import java.util.List;

import com.douane.entite.FRequerant;

public interface IRequerant {
	void updateRequerant(FRequerant requerant, Long id);
	void saveRequerant(FRequerant requerant);
	void dellRequerant(Long id);
	List<FRequerant> findAllRequerant();
}
