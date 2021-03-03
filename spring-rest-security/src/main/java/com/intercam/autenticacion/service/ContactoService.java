package com.intercam.autenticacion.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercam.autenticacion.entity.Contacto;
import com.intercam.autenticacion.repository.ContactoRepository;

@Service
@Transactional
public class ContactoService {

    @Autowired
    ContactoRepository contactoRepository;

    public List<Contacto> obtenerTodos(){
        List<Contacto> lista = contactoRepository.findAll();
        return lista;
    }

    public Optional<Contacto> obtenerPorId(Long id){
        return contactoRepository.findById(id);
    }

 
    public Contacto guardar(Contacto contacto){
    	return contactoRepository.save(contacto);
    }

    public void borrar(Long id){
    	contactoRepository.deleteById(id);
    }


    public boolean existePorId(Long id){
        return contactoRepository.existsById(id);
    }
}