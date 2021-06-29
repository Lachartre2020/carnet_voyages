package com.stepupacademy.carnetdevoyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepupacademy.carnetdevoyage.entity.Etape;
import com.stepupacademy.carnetdevoyage.repository.EtapeRepository;

@Service
public class EtapeService {

    @Autowired
    private EtapeRepository etapeRepository;

    public List<Etape> findAll() {
        return etapeRepository.findAll();
    }

    public Optional<Etape> findById(Long id)
    {
    	return etapeRepository.findById(id);
    }

	public void save(Etape etape) {
		etapeRepository.save(etape);		
	}
	
	public void delete(Etape etape) {
		etapeRepository.delete(etape);
	}

	
	
	
}
