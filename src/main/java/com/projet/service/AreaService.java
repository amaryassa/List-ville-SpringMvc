package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.DAO.IAreaDAO;
import com.projet.model.Area;

@Service
public class AreaService implements IAreaService{
	@Autowired
	private IAreaDAO areaDao;
	
	
	public IAreaDAO getAreaDao() {
		return areaDao;
	}
	public void setAreaDao(IAreaDAO areaDao) {
		this.areaDao = areaDao;
	}
	
	
	@Transactional(readOnly=true)
	public List<Area> recupererListeArea(int page, int size , String motCle) {
		if(page>0) page=page*size;
		List<Area> areaList = areaDao.recupererListeArea( page, size ,motCle);
        return areaList;
	}
	@Transactional(readOnly=true)
	public Long totalArea(String motCle) {
		Long numberTotal = areaDao.totalArea(motCle);
		return numberTotal;
	}
}