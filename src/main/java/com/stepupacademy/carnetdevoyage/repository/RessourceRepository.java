package com.stepupacademy.carnetdevoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepupacademy.carnetdevoyage.entity.Ressource;

@Repository
public interface RessourceRepository extends JpaRepository<Ressource, Long> {

}