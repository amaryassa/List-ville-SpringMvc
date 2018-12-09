package com.projet.service;

import java.util.List;

import com.projet.model.City;

public interface ICityService {
	public List<City> recupererListeCity(int page, int size, String motCle);
	public Long  totalCity(String motCle);
}
