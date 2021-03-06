package com.intercam.autenticacion.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intercam.autenticacion.entity.Producto;
import com.intercam.autenticacion.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> obtenerTodos(){
        List<Producto> lista = productoRepository.findAll();
        return lista;
    }

    public Optional<Producto> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto Producto){
    	return productoRepository.save(Producto);
    }

    public void borrar(Long id){
    	productoRepository.deleteById(id);
    }

   /* public boolean existePorNombre(String nc){
        return ProductoRepository.existsByNombreProducto(nc);
    }*/

    public boolean existePorId(Long id){
        return productoRepository.existsById(id);
    }
}