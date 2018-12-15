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
import com.projet.service.IAreaService;

@Controller
public class AreaController {
//	recupération de l'interface du service
	private IAreaService areaService;
	public IAreaService getAreaService() {
		return areaService;
	}
	@Autowired(required=true)
    @Qualifier(value="areaService")
	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}
	  @RequestMapping(value="/area", method = RequestMethod.GET)
	    public String recupererListePays(
	    	    @RequestParam(required=false, defaultValue="0") int page,
	    		@RequestParam(required=false, defaultValue="") String motCle,
	    		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
	    	List<Area> listeArea = areaService.recupererListeArea(page, size,motCle);
	        map.addAttribute("listeArea", listeArea);
	        return "pageArea";
	    }
	  @ResponseBody
	  @RequestMapping(value="/area1", method = RequestMethod.GET, headers="Accept=application/json")
	    public ResponseEntity<AffichageForRest> recupererListeAreaApi(
	    @RequestParam(required=false, defaultValue="0") int page,
		@RequestParam(required=false, defaultValue="") String motCle,
		@RequestParam(required=false, defaultValue="10") int size, ModelMap map) {
		  List<Area> listeArea = areaService.recupererListeArea(page, size,motCle);
	    	Long numberTotalElements = areaService.totalArea(motCle);
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
	    	affichageForRest.setResultList(listeArea);
	    	return new ResponseEntity<AffichageForRest>(affichageForRest, HttpStatus.OK);
	    }
}
