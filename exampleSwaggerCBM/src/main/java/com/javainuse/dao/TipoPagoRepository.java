package com.javainuse.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javainuse.model.TipoPago;



@Transactional(readOnly = true )
@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer>{
	
	/*@Query("select tp.tpaId,tp.tapDescripcion,tp.tpaEstatus,"
			+ " tp.tpaFHEstatus, tp.tpaCausaEstatus,tp.tpaUsuAlta,"
			+ " tp.tpaFHAlta, tp.tpaUsuModifica,tp.tpaFHModifica,"
			+ " tp.tpaObservaciones from TipoPago tp")
	 List<TipoPago> getByNameAll(); */


	
}

