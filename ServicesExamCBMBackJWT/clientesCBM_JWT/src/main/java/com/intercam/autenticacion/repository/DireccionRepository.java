package com.intercam.autenticacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intercam.autenticacion.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long>{

}

