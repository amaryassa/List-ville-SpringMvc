package com.projet.DAO;

import java.util.List;

import com.projet.model.Street;

public interface IStreetDAO {
	public List<Street> recupererListeStreet(int page, int size);
	public Long  totalStreet();
}
