package com.projet.service;

import java.util.List;

import com.projet.model.Street;

public interface IStreetService {
	public List<Street> recupererListeStreet(int page, int size, String motCle);
	public Long  totalStreet(String motCle);
}
