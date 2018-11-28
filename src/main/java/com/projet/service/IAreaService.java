package com.projet.service;

import java.util.List;

import com.projet.model.Area;

public interface IAreaService {
	public List<Area> recupererListeArea();
	public Long  totalArea();
}
