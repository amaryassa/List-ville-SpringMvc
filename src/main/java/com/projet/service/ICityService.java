package com.projet.service;

import java.util.List;

import com.projet.model.City;

public interface ICityService {
	public List<City> recupererListeCity(int page, int size);
	public Long  totalCity();
}
