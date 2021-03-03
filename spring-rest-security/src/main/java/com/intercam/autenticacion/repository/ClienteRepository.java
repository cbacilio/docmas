package com.intercam.autenticacion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.intercam.autenticacion.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    //Optional<Cliente> findByNombreCliente(String nc);
    //boolean existsByNombreCliente(String nc);

}

