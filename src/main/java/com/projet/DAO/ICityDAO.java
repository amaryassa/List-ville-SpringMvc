package com.projet.DAO;

import java.util.List;

import com.projet.model.City;

public interface ICityDAO {
	public List<City> recupererListeCity(int page, int size, String motCle);
	public Long  totalCity(String motCle);
}
