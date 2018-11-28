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
import org.springframework.web.bind.annotation.RequestParam;
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
    	List<Country> listePays = countryService.recupererListePays(0, 20);
    	
        map.addAttribute("listCountry", listePays);
        return "pagePays";
    }
    
    @RequestMapping(value="/country1", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<AffichageForRest> recupererListePaysApi(
    		@RequestParam(required=false, defaultValue="0") int page,
    		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
    	
    	List<Country> listePays = countryService.recupererListePays(page, size);
    	Long numberTotalElements = countryService.totalPays();
    	int lastPage = (int) (Math.ceil(numberTotalElements / size));
    	
    	AffichageForRest affichageForRest = new AffichageForRest(); 
    	affichageForRest.setTotalElements(numberTotalElements);
    	affichageForRest.setPage(page);
    	affichageForRest.setSize(size);
    	affichageForRest.setLastPage(lastPage);
    	affichageForRest.setResultList(listePays);
    	
    	return new ResponseEntity<AffichageForRest>(affichageForRest, HttpStatus.OK);
    }

    

}