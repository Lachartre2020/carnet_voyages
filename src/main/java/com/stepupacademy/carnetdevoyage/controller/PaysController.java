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

    @GetMapping("/lists")
    public String listPays(Model model)
    {
        List<Pays> paysList = new ArrayList<>();
        paysList = paysService.findAll();
        model.addAttribute("pays", paysList);

        return "paysList";
    }

    @PostMapping("/lists")
    public String createPays(String name, String dateDeb, String dateFin ) throws ParseException
    {
    	Date dateDebCast=new SimpleDateFormat("yyyy-MM-dd").parse(dateDeb);
    	Date dateFinCast=new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
    	
    	Pays pays = new Pays();
    	pays.setName(name);
    	pays.setDateDeb(dateDebCast);
    	pays.setDateFin(dateFinCast);
    	paysService.save(pays);

        return "redirect:/lists/";
    }

    @PostMapping("/modif/{idPays}")
    public String updatePays(String name, String dateDeb, String dateFin, @PathVariable Long idPays) throws ParseException
    {
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

        return "redirect:/lists/";
    }     

    @GetMapping("/lists/delete/{idPays}")
    public String deletePays(Model model, @PathVariable Long idPays)
    {
        Pays pays = new Pays();
        Optional<Pays> optionalPays = paysService.findById(idPays);
        if (optionalPays.isPresent()) 
		{        
        	pays = optionalPays.get();
        	paysService.delete(pays);
		}
        return "redirect:/lists/";
    }      

    @GetMapping("/list/{idPays}/modif")
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
