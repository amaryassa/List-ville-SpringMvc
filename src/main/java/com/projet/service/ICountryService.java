package com.projet.service;

import java.util.List;

import com.projet.model.Country;

public interface ICountryService {
	public List<Country> recupererListePays(int page, int size, String motCle);
	public Long  totalPays(String motCle);
	
}