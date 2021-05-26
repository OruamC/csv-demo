package com.readcsv.democsv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.readcsv.democsv.entity.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

}
