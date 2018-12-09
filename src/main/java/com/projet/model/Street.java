package com.projet.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="street")
public class Street {
	
	
	@Id
	@Column(name="ID_STREET_NAME", nullable=false)
    private int idStreetName;

    @Column(name="ID_STREET_TYPE")
    private BigInteger  id_Street_Type;

    @ManyToOne    	
    @JoinColumn(name="ID_CITY")
    private City  StreetCity;
    

	@Column(name="STREET_NAME_LABEL")
    private String  StreetNameLabel;
    
    
	


	public City getStreetCity() {
		return StreetCity;
	}


	public void setStreetCity(City streetCity) {
		StreetCity = streetCity;
	}


	public int getIdStreetName() {
		return idStreetName;
	}


	public void setIdStreetName(int idStreetName) {
		this.idStreetName = idStreetName;
	}





	public BigInteger getId_Street_Type() {
		return id_Street_Type;
	}


	public void setId_Street_Type(BigInteger id_Street_Type) {
		this.id_Street_Type = id_Street_Type;
	}


	public String getStreetNameLabel() {
		return StreetNameLabel;
	}


	public void setStreetNameLabel(String streetNameLabel) {
		StreetNameLabel = streetNameLabel;
	}


		
	
}
