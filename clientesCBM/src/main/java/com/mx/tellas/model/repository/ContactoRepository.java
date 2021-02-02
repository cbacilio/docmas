package com.mx.tellas.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.tellas.model.entitys.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long>{

}

