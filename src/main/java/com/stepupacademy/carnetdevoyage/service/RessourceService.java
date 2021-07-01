package com.stepupacademy.carnetdevoyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepupacademy.carnetdevoyage.entity.Ressource;
import com.stepupacademy.carnetdevoyage.repository.RessourceRepository;

@Service
public class RessourceService {
	
    @Autowired
    private RessourceRepository ressourceRepository;

    public List<Ressource> findAll() {
        return ressourceRepository.findAll();
    }

    public Optional<Ressource> findById(Long id)
    {
    	return ressourceRepository.findById(id);
    }

	public void save(Ressource ressource) {
		ressourceRepository.save(ressource);		
	}
	
	public void delete(Ressource ressource) {
		ressourceRepository.delete(ressource);
	}
}
