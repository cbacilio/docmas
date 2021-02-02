
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
@Table(name="cliente")
@Getter
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE")
	private long idCliente;

	@Column(name="ID_DIRECCION")
	private long idDireccion;
	
	@Column(name="ID_CONTACTO")
	private long idContacto;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDO_PATERNO")
	private String ApellidoPaterno;
	
	
	@Column(name="APELLIDO_MATERNO")
	private String apellidoMaterno;
	
	@Column(name="EDAD")
	private String edad;
	
	@Column(name="SEXO")
	private String sexo;
	
	@Column(name="RFC")
	private String rfc;
	

}
