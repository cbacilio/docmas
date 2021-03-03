package com.intercam.autenticacion.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intercam.autenticacion.entity.ProductoJWT;

@Repository
public interface ProductoJWTRepository extends JpaRepository<ProductoJWT, Long> {
    Optional<ProductoJWT> findByNombreProducto(String np);
    boolean existsByNombreProducto(String np);
}