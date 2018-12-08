package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.DAO.IStreetDAO;
import com.projet.model.Street;

@Service
public class StreetService implements IStreetService {

	@Autowired
    private IStreetDAO streetDao;
	
	public IStreetDAO getStreetDao() {
		return streetDao;
	}
		
	public void setStreetDao(IStreetDAO streetDao) {
		this.streetDao = streetDao;
	}

	@Transactional(readOnly=true)
	public List<Street> recupererListeStreet(int page, int size) {
		if(page>0) page=page*size;
		List<Street> listStreet = streetDao.recupererListeStreet( page, size);

		return listStreet;		
	}
	@Transactional(readOnly=true)
	public Long totalStreet() {
		Long numberTotal = streetDao.totalStreet();
		return numberTotal;
	}

}
