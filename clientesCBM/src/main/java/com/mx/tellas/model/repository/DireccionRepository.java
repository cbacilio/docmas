package com.mx.tellas.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.tellas.model.entitys.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

}

