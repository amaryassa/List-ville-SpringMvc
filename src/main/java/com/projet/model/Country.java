package com.projet.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {

	    @Id
	    @Column(name="ID_COUNTRY", nullable=false)
	    private int idCountry;
	    
	    @Column(name="CODE_ISO", nullable=false)
	    private String codeIso;
	    
	    
	    @OneToMany(mappedBy="AreaCountry", fetch=FetchType.LAZY) //le lazy: quand je demande de charger une categorie il va charger que les information id et nomCategorie sans les Produits sauf � la demande
		private Collection<Area> area;
	    
	    
	    
	    

		public int getIdCountry() {
			return idCountry;
		}

		public void setIdCountry(int idCountry) {
			this.idCountry = idCountry;
		}

		public String getCodeIso() {
			return codeIso;
		}

		public void setCodeIso(String codeIso) {
			this.codeIso = codeIso;
		}
	}

