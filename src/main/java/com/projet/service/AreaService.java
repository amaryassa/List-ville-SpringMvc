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
	public List<Area> recupererListeArea() {
		List<Area> areaList = areaDao.recupererListeArea();
        return areaList;
	}
	@Transactional(readOnly=true)
	public Long totalArea() {
		Long numberTotal = areaDao.totalArea();
		return numberTotal;
	}
}