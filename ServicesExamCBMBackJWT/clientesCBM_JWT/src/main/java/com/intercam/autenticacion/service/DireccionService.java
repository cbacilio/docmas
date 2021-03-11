package com.intercam.autenticacion.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercam.autenticacion.entity.Direccion;
import com.intercam.autenticacion.repository.DireccionRepository;

@Service
@Transactional
public class DireccionService {

    @Autowired
    DireccionRepository direccionRepository;

    public List<Direccion> obtenerTodos(){
        List<Direccion> lista = direccionRepository.findAll();
        return lista;
    }

    public Optional<Direccion> obtenerPorId(Long id){
        return direccionRepository.findById(id);
    }

 
    public Direccion guardar(Direccion direccion){
    	return direccionRepository.save(direccion);
    }

    public void borrar(Long id){
    	direccionRepository.deleteById(id);
    }


    public boolean existePorId(Long id){
        return direccionRepository.existsById(id);
    }
}