package com.mx.intercam.model.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.intercam.model.entitys.TipoPago;

@Transactional(readOnly = true )
@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer>{

}

