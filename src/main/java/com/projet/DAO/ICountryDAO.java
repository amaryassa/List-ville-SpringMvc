package com.projet.DAO;



import java.util.List;


import com.projet.model.Country;

public interface ICountryDAO {
	public List<Country> recupererListePays(int page, int size, String motCle);
	public Long  totalPays(String motCle);
}