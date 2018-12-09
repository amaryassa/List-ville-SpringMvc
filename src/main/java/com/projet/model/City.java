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
@Table(name="city")
public class City {
	
	 	@Id
		@Column(name="ID_CITY", nullable=false)
	    private int idCity;

	    @Column(name="REFCODE")
	    private String refcode;
	  
		
	//	
		@ManyToOne
	    @JoinColumn(name="ID_AREA")
	    private Area CityArea;
	    
	    @Column(name="CITY_NAME")
	    private String cityName;
	    
	    
	    public int getIdCity() {
			return idCity;
		}
		
		public Area getCityArea() {
			return CityArea;
		}

		public void setCityArea(Area cityArea) {
			CityArea = cityArea;
		}

		public void setIdCity(int idCity) {
			this.idCity = idCity;
		}
		public String getRefcode() {
			return refcode;
		}
		public void setRefcode(String refcode) {
			this.refcode = refcode;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
		}
		public int getIdZip() {
			return idZip;
		}
		public void setIdZip(int idZip) {
			this.idZip = idZip;
		}
		@Column(name="ID_ZIP")
	    private int idZip;
		
		
		   @OneToMany(mappedBy="StreetCity", fetch=FetchType.LAZY) //le lazy: quand je demande de charger une categorie il va charger que les information id et nomCategorie sans les Produits sauf à la demande
			private Collection<Street> street;

}
