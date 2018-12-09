package com.projet.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.DAO.ICityDAO;
import com.projet.model.City;
import com.projet.model.Country;

@Service
public class CityService implements ICityService {
	@Autowired
    private ICityDAO cityDao;
	public ICityDAO getCityDao() {
		return cityDao;
	}
	public void setCityDao(ICityDAO cityDao) {
		this.cityDao = cityDao;
	}
	@Transactional(readOnly=true)
	public List<City> recupererListeCity(int page, int size , String motCle) {
		if(page>0) page=page*size;
		List<City> listCity = cityDao.recupererListeCity( page, size ,motCle);

		return listCity;		
	}
	@Transactional(readOnly=true)
	public Long totalCity(String motCle) {
		Long numberTotal = cityDao.totalCity(motCle);
		return numberTotal;
	}

}
