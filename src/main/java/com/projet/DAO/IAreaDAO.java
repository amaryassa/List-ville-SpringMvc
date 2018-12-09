package com.projet.DAO;

import java.util.List;

import com.projet.model.Area;

public interface IAreaDAO {
	public List<Area> recupererListeArea(int page, int size, String motCle);
	public Long  totalArea(String motCle);
}
