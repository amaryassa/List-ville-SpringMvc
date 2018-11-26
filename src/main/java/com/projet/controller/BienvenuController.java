package com.projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bienvenu")
public class BienvenuController {

@RequestMapping(method = RequestMethod.GET)
public String afficherBienvenu(final ModelMap map) {
map.addAttribute("personne", "Toto");
return "bienvenu";
}
}