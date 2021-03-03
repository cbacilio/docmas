package com.intercam.autenticacion.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="abono")
@Getter
@Setter
public class Abono {

	public Abono() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ABONO")
	private long idAbono;
	
	@Column(name="ID_CLIENTE")
	private long idCliente;
	
	@Column(name="ID_VENTA")
	private long idVenta;
	
	@Column(name="MONTO")
	private int monto;
	
	@Column(name="FECHA")
	private Date fecha;
	
	@ManyToOne
    @JoinColumn(name = "ID_CLIENTE",nullable = true, insertable = false, updatable = false)
    private Cliente cliente;
	
	@ManyToOne
    @JoinColumn(name = "ID_VENTA",nullable = true, insertable = false, updatable = false)
    private Venta venta;
	
	

}
