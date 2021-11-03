package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.entities.Sale;

@Repository
public interface SalesRepository extends JpaRepository<Sale, Long>{

}
