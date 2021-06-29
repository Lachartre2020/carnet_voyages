package com.stepupacademy.carnetdevoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepupacademy.carnetdevoyage.entity.Etape;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, Long> {

}


