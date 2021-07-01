package com.stepupacademy.carnetdevoyage.controller;

import com.stepupacademy.carnetdevoyage.entity.Pays;
import com.stepupacademy.carnetdevoyage.service.PaysService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class PaysController
{
    @Autowired
    private PaysService paysService;

    @GetMapping("/list/pays")
    public String listPays(Model model)
    {
        List<Pays> paysList = new ArrayList<>();
        paysList = paysService.findAll();
        model.addAttribute("pays", paysList);

        return "paysList";
    }

    @PostMapping("/list/pays/creat")
    public String createPays(String name, String dateDeb, String dateFin ) throws ParseException
    {
    	Date dateDebCast=new SimpleDateFormat("yyyy-MM-dd").parse(dateDeb);
    	Date dateFinCast=new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);

    	Pays pays = new Pays();
    	pays.setName(name);
    	pays.setDateDeb(dateDebCast);
    	pays.setDateFin(dateFinCast);
    	paysService.save(pays);

        return "redirect:/list/pays";
    }

    			 
    @PostMapping("/list/pays/{idPays}/modif")
    public String modifPays(String name, String dateDeb, String dateFin, @PathVariable Long idPays) throws ParseException
    {
    	 System.out.println("*****" + idPays);	 
    	Date dateDebCast=new SimpleDateFormat("yyyy-MM-dd").parse(dateDeb);
    	Date dateFinCast=new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
          	
    	Pays pays = new Pays();
        Optional<Pays> optionalPays = paysService.findById(idPays);
        if (optionalPays.isPresent()) 
		{
        	pays=optionalPays.get();
        	pays.setName(name);
        	pays.setDateDeb(dateDebCast);
        	pays.setDateFin(dateFinCast);
        	paysService.save(pays);
		}    	

        return "redirect:/list/pays";
    }     
    		   
    @GetMapping("/list/pays/{idPays}/supp")
    public String suppPays(Model model, @PathVariable Long idPays)
    {
        Pays pays = new Pays();
        Optional<Pays> optionalPays = paysService.findById(idPays);
        if (optionalPays.isPresent()) 
		{        
        	pays = optionalPays.get();
        	paysService.delete(pays);
		}

        return "redirect:/list/pays";
    }      

    @GetMapping("/list/pays/{idPays}/AffichModif")
    public String affichModifPays(Model model, @PathVariable Long idPays)
    {
        Pays pays = new Pays();
        Optional<Pays> optionalPays = paysService.findById(idPays);
        if (optionalPays.isPresent()) 
		{        
        	pays = optionalPays.get();
        	model.addAttribute("pays", pays);

        	return "paysUpdate";
		}
        return "paysList";
    }
}
