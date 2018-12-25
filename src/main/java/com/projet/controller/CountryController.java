package com.projet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String recupererListePays(
    		@RequestParam(required=false, defaultValue="0") int page,
    		@RequestParam(required=false, defaultValue="") String motCle,
    		
    		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
    	List<Country> listePays = countryService.recupererListePays(page, size, motCle);
    	Long numberTotalElements = countryService.totalPays(motCle);
    	int lastPage = (int) (Math.ceil(numberTotalElements / size));
    	double testLastPage= (double)numberTotalElements / (double)size;
    	if(lastPage==testLastPage) {
    		lastPage=lastPage-1;
    	}
    	map.addAttribute("motCle", motCle);
        map.addAttribute("listCountry", listePays);
        map.addAttribute("lastPage", lastPage);
        map.addAttribute("currentPage", page);
        return "pagePays";
    }
    @ResponseBody
    @RequestMapping(value="/country1", method = RequestMethod.GET, headers="Accept=application/json;")
    public ResponseEntity<AffichageForRest> recupererListePaysApi(
		@RequestParam(required=false, defaultValue="0") int page,
		@RequestParam(required=false, defaultValue="") String motCle,
		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
    	List<Country> listePays = countryService.recupererListePays(page, size, motCle);
    	Long numberTotalElements = countryService.totalPays(motCle);
    	int lastPage = (int) (Math.ceil(numberTotalElements / size));
    	double testLastPage= (double)numberTotalElements / (double)size;
    	if(lastPage==testLastPage) {
    		lastPage=lastPage-1;
    	}
    	AffichageForRest affichageForRest = new AffichageForRest(); 
    	affichageForRest.setTotalElements(numberTotalElements);
    	affichageForRest.setPage(page);
    	affichageForRest.setSize(size);
    	affichageForRest.setLastPage(lastPage);
    	affichageForRest.setResultList(listePays);
    	return new ResponseEntity<AffichageForRest>(affichageForRest, HttpStatus.OK);
    }
}