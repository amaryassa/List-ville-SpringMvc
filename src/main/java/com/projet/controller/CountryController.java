package com.projet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.model.Area;
import com.projet.model.Country;
import com.projet.service.ICountryService;

@Controller
public class CountryController {
	
    private ICountryService countryService;
		
    public ICountryService getCountryService() {
		return countryService;
	}
    
    @Autowired(required=true)
    @Qualifier(value="countryService")
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}
    
    @RequestMapping(value="/country", method = RequestMethod.GET)
    public String recupererListePays(ModelMap map) {
    	List<Country> listePays = countryService.recupererListePays();
    	
        map.addAttribute("listCountry", listePays);
        return "pagePays";
    }
    
    @RequestMapping(value="/country1", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Country>> recupererListePaysApi(ModelMap map) {
    	List<Country> listePays = countryService.recupererListePays();
    	
    	return new ResponseEntity<List<Country>>(listePays, HttpStatus.OK);
    }

    

}