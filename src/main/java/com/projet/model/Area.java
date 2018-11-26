package com.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="area")
public class Area {
	
    @Id
    @Column(name="ID_AREA", nullable=false)
    private int idArea;

    @Column(name="LANGUAGE_ID")
    private int languageId;
    
    @Column(name="AREA_LABEL")
    private String areaLabel;
    
    @ManyToOne
	@JoinColumn(name="ID_COUNTRY")
	private Country idCountry;

	public Country getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Country idCountry) {
		this.idCountry = idCountry;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}


	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getAreaLabel() {
		return areaLabel;
	}

	public void setAreaLabel(String areaLabel) {
		this.areaLabel = areaLabel;
	}
    
}
