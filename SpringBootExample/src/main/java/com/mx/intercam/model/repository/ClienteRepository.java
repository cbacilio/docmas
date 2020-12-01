package com.mx.intercam.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.intercam.model.entitys.Inventario;

@Repository
public interface ClienteRepository extends JpaRepository<Inventario, Long>{

}

