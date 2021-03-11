package com.intercam.autenticacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intercam.autenticacion.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}

