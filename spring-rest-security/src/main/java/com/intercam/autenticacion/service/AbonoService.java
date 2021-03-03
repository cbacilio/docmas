package com.intercam.autenticacion.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercam.autenticacion.entity.Abono;
import com.intercam.autenticacion.repository.AbonoRepository;

@Service
@Transactional
public class AbonoService {

    @Autowired
    AbonoRepository abonoRepository;

    public List<Abono> obtenerTodos(){
        List<Abono> lista = abonoRepository.findAll();
        return lista;
    }

    public Optional<Abono> obtenerPorId(Long id){
        return abonoRepository.findById(id);
    }

 
    public Abono guardar(Abono abono){
    	return abonoRepository.save(abono);
    }

    public void borrar(Long id){
    	abonoRepository.deleteById(id);
    }


    public boolean existePorId(Long id){
        return abonoRepository.existsById(id);
    }
}