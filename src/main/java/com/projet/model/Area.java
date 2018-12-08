package com.projet.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Country AreaCountry;
    
    
    
    
    @OneToMany(mappedBy="CityArea", fetch=FetchType.LAZY) //le lazy: quand je demande de charger une categorie il va charger que les information id et nomCategorie sans les Produits sauf à la demande
	private Collection<City> city;

	

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

	public Country getAreaCountry() {
		return AreaCountry;
	}

	public void setAreaCountry(Country areaCountry) {
		AreaCountry = areaCountry;
	}

	

	
    
}
