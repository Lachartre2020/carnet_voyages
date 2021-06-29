package com.stepupacademy.carnetdevoyage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepupacademy.carnetdevoyage.entity.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {

}