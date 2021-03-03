package com.intercam.autenticacion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO_INVENTARIO")
public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5325682587383950913L;
	
	@Id
	@Column(name = "ID_ESTADO_INVENTARIO")
	private String idEstadoInventario;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	public String getIdEstadoInventario() {
		return idEstadoInventario;
	}

	public void setIdEstadoInventario(String idEstadoInventario) {
		this.idEstadoInventario = idEstadoInventario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
