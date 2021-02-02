package com.mx.tellas.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.tellas.model.entitys.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}

