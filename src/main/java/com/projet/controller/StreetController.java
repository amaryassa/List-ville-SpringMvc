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

import com.projet.model.Street;
import com.projet.service.IStreetService;



@Controller
public class StreetController {
	
	 private IStreetService streetService;

	public IStreetService getStreetService() {
		return streetService;
	}
	@Autowired(required=true)
    @Qualifier(value="streetService")
	public void setStreetService(IStreetService streetService) {
		this.streetService = streetService;
	}
	
	
	
	@RequestMapping(value="/street", method = RequestMethod.GET)
    public String recupererListeStreet(
    		@RequestParam(required=false, defaultValue="0") int page,
    		@RequestParam(required=false, defaultValue="") String motCle,
    		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
    	List<Street> listeStreet = streetService.recupererListeStreet(page, size,motCle);
    	Long numberTotalElements = streetService.totalStreet(motCle);
    	int lastPage = (int) (Math.ceil(numberTotalElements / size));
    	double testLastPage= (double)numberTotalElements / (double)size;
    	if(lastPage==testLastPage) {
    		lastPage=lastPage-1;
    	}
    	
    	
    	map.addAttribute("motCle", motCle);
        map.addAttribute("lastPage", lastPage);
        map.addAttribute("currentPage", page);
        map.addAttribute("listStreet", listeStreet);
        return "pageStreet";
    }
    @ResponseBody
    @RequestMapping(value="/street1", method = RequestMethod.GET, headers="Accept=application/json;")
    public ResponseEntity<AffichageForRest> recupererListePaysApi(
		@RequestParam(required=false, defaultValue="0") int page,
		@RequestParam(required=false, defaultValue="") String motCle,
		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
	
    	List<Street> listePays = streetService.recupererListeStreet(page, size, motCle);
    	
    	Long numberTotalElements = streetService.totalStreet(motCle);
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
