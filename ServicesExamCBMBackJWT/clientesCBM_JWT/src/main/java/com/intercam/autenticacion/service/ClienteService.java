package com.intercam.autenticacion.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercam.autenticacion.entity.Cliente;
import com.intercam.autenticacion.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos(){
        List<Cliente> lista = clienteRepository.findAll();
        return lista;
    }

    public Optional<Cliente> obtenerPorId(Long id){
        return clienteRepository.findById(id);
    }

    /*public Optional<Cliente> obtenerPorNombre(String nc){
        return clienteRepository.findByNombreCliente(nc);
    }
*/
    public Cliente guardar(Cliente cliente){
    	return clienteRepository.save(cliente);
    }

    public void borrar(Long id){
    	clienteRepository.deleteById(id);
    }

   /* public boolean existePorNombre(String nc){
        return clienteRepository.existsByNombreCliente(nc);
    }*/

    public boolean existePorId(Long id){
        return clienteRepository.existsById(id);
    }
}