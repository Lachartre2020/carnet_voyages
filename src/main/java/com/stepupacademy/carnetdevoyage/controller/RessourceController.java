package com.stepupacademy.carnetdevoyage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stepupacademy.carnetdevoyage.entity.Etape;
import com.stepupacademy.carnetdevoyage.entity.Ressource;
import com.stepupacademy.carnetdevoyage.service.EtapeService;
import com.stepupacademy.carnetdevoyage.service.RessourceService;

@Controller
public class RessourceController {

	@Autowired
	private EtapeService etapeService;

	@Autowired
	private RessourceService ressourceService;

	@GetMapping("/{idPays}/{idEtape}/list/ressources")
    public String listRessource(Model model, @PathVariable Long idPays, @PathVariable Long idEtape)
    {
         if (idEtape != null) {
            Optional<Etape> optionalEtape = etapeService.findById(idEtape);
            Etape etape = new Etape();
            List<Ressource> ressource = new ArrayList<>();
            if (optionalEtape.isPresent()) {
                etape = optionalEtape.get();
                ressource = optionalEtape.get().getRessources();
                model.addAttribute("idPays",idPays);                
                model.addAttribute("etape",etape);
                model.addAttribute("ressources",ressource);                
            }
        }   
        return "ressourceList";
    }   
    


    @PostMapping("/{idPays}/{idEtape}/list/ressource/creat")
    public String createRessource(@PathVariable Long idPays, @PathVariable Long idEtape, Long id, String lienSite)
    {
    	if (id != null) {
    		Ressource ressource = new Ressource();
    		Optional<Etape> optionalEtape = etapeService.findById(id);
    		Etape etape = new Etape();
    		List<Ressource> ressources = new ArrayList<>();
    		if (optionalEtape.isPresent()) {
    			ressource.setEtape(optionalEtape.get());
    			ressource.setLienSite(lienSite);
    			ressourceService.save(ressource);
    		}	
    	}    

        return "redirect:/" + idPays + "/" + idEtape + "/list/ressources";
    }       
 
    @GetMapping("/{idPays}/{idEtape}/list/ressource/{idRessource}/supp")
    public String SuppRessource( @PathVariable Long idPays, @PathVariable Long idEtape, @PathVariable Long idRessource)
    {
    	Ressource ressource = new Ressource();
		Optional<Ressource> optionalRessource = ressourceService.findById(idRessource);
        if (optionalRessource.isPresent()) 
		{        
        	ressource = optionalRessource.get();
        	ressourceService.delete(ressource);
		}
        
        return "redirect:/" + idPays + "/" + idEtape + "/list/ressources";
    }    
    
    @PostMapping("/{idPays}/{idEtape}/list/ressource/{idRessource}/modif")
    public String modifRessource(String lienSite, @PathVariable Long idPays, @PathVariable Long idEtape, @PathVariable Long idRessource)
    {
    	Ressource ressource = new Ressource();
		Optional<Ressource> optionalRessource = ressourceService.findById(idRessource);
        if (optionalRessource.isPresent()) 
		{   
        	ressource=optionalRessource.get();
			ressource.setLienSite(lienSite);
			ressourceService.save(ressource);
		}    	

        return "redirect:/" + idPays + "/" + idEtape + "/list/ressources";
    }         
    
    @GetMapping("/{idPays}/{idEtape}/list/ressource/affichModif/{idRessource}")
    public String affichModifRessource(Model model, @PathVariable Long idPays, @PathVariable Long idEtape, @PathVariable Long idRessource)
    {
    	Ressource ressource = new Ressource();
		Optional<Ressource> optionalRessource = ressourceService.findById(idRessource);
        if (optionalRessource.isPresent()) 
		{        
        	ressource = optionalRessource.get();
            model.addAttribute("idEtape",idEtape);
        	model.addAttribute("ressource", ressource);
            return "ressourceUpdate";
		}
        return "redirect:/" + idPays + "/" + idEtape + "/list/ressources";
    }     
    
    
}
