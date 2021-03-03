package com.intercam.autenticacion.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercam.autenticacion.entity.Venta;
import com.intercam.autenticacion.repository.VentaRepository;

@Service
@Transactional
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    public List<Venta> obtenerTodos(){
        List<Venta> lista = ventaRepository.findAll();
        return lista;
    }

    public Optional<Venta> obtenerPorId(Long id){
        return ventaRepository.findById(id);
    }

 
    public Venta guardar(Venta venta){
    	return ventaRepository.save(venta);
    }

    public void borrar(Long id){
    	ventaRepository.deleteById(id);
    }


    public boolean existePorId(Long id){
        return ventaRepository.existsById(id);
    }
}