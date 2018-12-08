package com.projet.DAO;

import java.util.List;

import com.projet.model.City;

public interface ICityDAO {
	public List<City> recupererListeCity(int page, int size);
	public Long  totalCity();
}
