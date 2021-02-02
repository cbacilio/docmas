package com.mx.tellas.model.entitys;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="venta")
@Getter
@Setter
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_VENTA")
	private long idVenta;
	
	@Column(name="ID_PRODUCTO")
	private long idProducto;

	@Column(name="ID_CLIENTE")
	private long idCliente;
	
	@Column(name="SALDO")
	private BigInteger saldo;
	
	@Column(name="FECHA_VENTA")
	private Date fechaVenta;
	
	
	@Column(name="FECHA_CANCELACION")
	private Date fechaCancelacion;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="COSTO")
	private BigInteger costo;
	

	@Column(name="ENGANCHE")
	private BigInteger enganche;

	

}
