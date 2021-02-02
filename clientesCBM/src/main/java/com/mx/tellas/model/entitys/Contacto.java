package com.mx.tellas.model.entitys;

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
@Table(name="contacto")
@Getter
@Setter
public class Contacto {

	public Contacto() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CONTACTO")
	private long idContacto;
	
	@Column(name="ID_CLIENTE")
	private long idCliente;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	
	
}
