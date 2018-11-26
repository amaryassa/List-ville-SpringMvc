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
	    public String recupererListePays(ModelMap map) {
	    	List<Area> listeArea = areaService.recupererListeArea();
	        map.addAttribute("listeArea", listeArea);
	        return "pageArea";
	    }
	
	  @RequestMapping(value="/area1", method = RequestMethod.GET, headers="Accept=application/json")
	    public ResponseEntity<List<Area>> recupererListePaysApi(ModelMap map) {
	    	List<Area> listeArea = areaService.recupererListeArea();
	    	
	    	return new ResponseEntity<List<Area>>(listeArea, HttpStatus.OK);
	    }


}
