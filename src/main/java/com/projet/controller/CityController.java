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

import com.projet.model.City;
import com.projet.service.ICityService;
@Controller
public class CityController {
	

	private ICityService cityService;
	
	public ICityService getCityService() {
		return cityService;
	}
	
	 @Autowired(required=true)
	 @Qualifier(value="cityService")
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}
	
	
    @RequestMapping(value="/city", method = RequestMethod.GET)
    public String recupererListeCity(
    		@RequestParam(required=false, defaultValue="0") int page,
    		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
    	List<City> listeCity = cityService.recupererListeCity(page, size);
    	
        map.addAttribute("listeCity", listeCity);
        return "pageCity";
    }
    @ResponseBody
    @RequestMapping(value="/city1", method = RequestMethod.GET, headers="Accept=application/json;")
    public ResponseEntity<AffichageForRest> recupererListeCityApi(
		@RequestParam(required=false, defaultValue="0") int page,
		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
	
    	List<City> listePays = cityService.recupererListeCity(page, size);
    	Long numberTotalElements = cityService.totalCity();
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