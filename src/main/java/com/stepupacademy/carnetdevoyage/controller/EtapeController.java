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
import com.stepupacademy.carnetdevoyage.entity.Pays;
import com.stepupacademy.carnetdevoyage.service.EtapeService;
import com.stepupacademy.carnetdevoyage.service.PaysService;

@Controller
public class EtapeController {

    @Autowired
    private PaysService paysService;

    @Autowired
    private EtapeService etapeService;    
    
    @GetMapping("/list/{idPays}/etapes")
    public String listEtape(Model model, @PathVariable Long idPays)
    {
         if (idPays != null) {
            Optional<Pays> optionalPays = paysService.findById(idPays);
            Pays pays = new Pays();
            List<Etape> etapes = new ArrayList<>();
            if (optionalPays.isPresent()) {
                pays = optionalPays.get();
                etapes = optionalPays.get().getEtapes();
                model.addAttribute("pays",pays);
                model.addAttribute("etapes",etapes);
            }
        }   
        return "etapeList";
    }   
    
    @PostMapping("/list/{idPays}/etape")
    public String createEtape(Long id, String nameVille, String dateEtape, String resume) throws ParseException
    {
    	Date dateEtapeParse=new SimpleDateFormat("yyyy-MM-dd").parse(dateEtape);
    	if (id != null) {
    		Etape etape = new Etape();
    		Optional<Pays> optionalPays = paysService.findById(id);
    		Pays pays = new Pays();
    		List<Etape> etapes = new ArrayList<>();
    		if (optionalPays.isPresent()) {
    			etape.setPays(optionalPays.get());	
    			etape.setNameVille(nameVille);
    			etape.setDateEtape(dateEtapeParse);
    			etape.setResume(resume);
    			etapeService.save(etape);
    		}	
    	}    
    	return "redirect:/list/" + id + "/etapes";
    }    
    
    @GetMapping("/list/{idPays}/delete/{idEtape}")
    public String deleteEtape(@PathVariable Long idPays, @PathVariable Long idEtape)
    {
    	Etape etape = new Etape();
		Optional<Etape> optionalEtape = etapeService.findById(idEtape);
        if (optionalEtape.isPresent()) 
		{        
        	etape = optionalEtape.get();
        	etapeService.delete(etape);
		}
        return "redirect:/list/" + idPays + "/etapes";
    }    
    			  
    @PostMapping("/modif/{idPays}/{idEtape}")
    public String updateEtape(String nameVille, String dateEtape, String resume , @PathVariable Long idPays, @PathVariable Long idEtape) throws ParseException
    {
       	Date dateEtapeParse=new SimpleDateFormat("yyyy-MM-dd").parse(dateEtape);
    	
    	Etape etape = new Etape();
		Optional<Etape> optionalEtape = etapeService.findById(idEtape);
        if (optionalEtape.isPresent()) 
		{   
        	etape=optionalEtape.get();
			etape.setNameVille(nameVille);
			etape.setDateEtape(dateEtapeParse);
			etape.setResume(resume);
			etapeService.save(etape);
		}    	

        return "redirect:/list/" + idPays + "/etapes";
    }      
    
    @GetMapping("/list/{idPays}/affichModif/{idEtape}")
    public String affichModifEtape(Model model, @PathVariable Long idPays, @PathVariable Long idEtape)
    {
    	Etape etape = new Etape();
		Optional<Etape> optionalEtape = etapeService.findById(idEtape);
        if (optionalEtape.isPresent()) 
		{        
        	etape = optionalEtape.get();
        	model.addAttribute("etape", etape);
            model.addAttribute("idPays",idPays);
        	return "etapeUpdate";
		}
        return "redirect:/list/" + idPays + "/etapes";
    } 
  
}
