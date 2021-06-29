package com.stepupacademy.carnetdevoyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepupacademy.carnetdevoyage.entity.Pays;
import com.stepupacademy.carnetdevoyage.repository.PaysRepository;

@Service
public class PaysService {
    @Autowired
    private PaysRepository paysRepository;

    public List<Pays> findAll() {
        return paysRepository.findAll();
    }

    public Optional<Pays> findById(Long id)
    {
    	return paysRepository.findById(id);
    }

	public void save(Pays pays) {
		paysRepository.save(pays);		
	}
	
	public void delete(Pays pays) {
		paysRepository.delete(pays);
	}

}
