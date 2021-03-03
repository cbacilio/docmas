package com.intercam.autenticacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intercam.autenticacion.entity.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>{

}

