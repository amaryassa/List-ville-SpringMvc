package com.projet.model;

import java.math.BigInteger;
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
@Table(name="language")
public class Language {
	

	@Id
	@Column(name="LANGUAGE_ID", nullable=false)
    private BigInteger LanguageId;
	

    @Column(name="LANGUAGE_CODE")
    private String  languageCode;
    
    
    @Column(name="LANGUAGE_NAME")
    private String  languageName;
    
    @OneToMany(mappedBy="AreaCountry", fetch=FetchType.LAZY) //le lazy: quand je demande de charger une categorie il va charger que les information id et nomCategorie sans les Produits sauf à la demande
   	private Collection<Area> area;

	public BigInteger getLanguageId() {
		return LanguageId;
	}

	public void setLanguageId(BigInteger languageId) {
		LanguageId = languageId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
}
