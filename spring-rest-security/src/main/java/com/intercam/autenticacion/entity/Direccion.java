package com.intercam.autenticacion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="direccion")
@Getter
@Setter
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DIRECCION")
	private long idDireccion;
	
	
	@Column(name="ID_CLIENTE")
	private long idCliente;
	
	@Column(name="CALLE")
	private String calle;
	
	@Column(name="COLONIA")
	private String colonia;
	
	@Column(name="MUNICIPIO")
	private String municipio;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="CP")
	private String cp;
	
	

}
