package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.DAO.ICountryDAO;
import com.projet.model.Country;

@Service
public class CountryService implements ICountryService {
	
	@Autowired
    private ICountryDAO countryDao;
	
	public ICountryDAO getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(ICountryDAO countryDao) {
		this.countryDao = countryDao;
	}
	
	@Transactional(readOnly=true)
	public List<Country> recupererListePays(int page, int size, String motCle){
		if(page>0) page=page*size;
		List<Country> listCountry = countryDao.recupererListePays( page, size, motCle);

		return listCountry;		
	}
	@Transactional(readOnly=true)
	public Long totalPays(String motCle) {
		Long numberTotal = countryDao.totalPays(motCle);
		return numberTotal;
	}

	
}