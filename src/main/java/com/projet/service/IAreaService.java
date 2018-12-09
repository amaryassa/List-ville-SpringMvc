package com.projet.service;

import java.util.List;

import com.projet.model.Area;

public interface IAreaService {
	public List<Area> recupererListeArea(int page, int size, String motCle);
	public Long  totalArea(String motCle);
}
