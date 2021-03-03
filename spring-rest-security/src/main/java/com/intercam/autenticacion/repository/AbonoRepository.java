package com.intercam.autenticacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intercam.autenticacion.entity.Abono;

@Repository
public interface AbonoRepository extends JpaRepository<Abono, Long>{

}

