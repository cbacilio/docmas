package com.intercam.autenticacion.entity;
//package com.mx.intercam.model.entitys;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="cliente")
//public class Cliente implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -6149138544662296909L;
//	
//	public Cliente() {
//		
//	}
//	
//	public Cliente(Long id, String nombre,String apellidoPaterno,
//			String apellidoMaterno, Date fechaNacimiento,Integer ingresos,String codigoPostal) {
//		this.id = id;
//		this.nombre = nombre;
//		this.apellidoPaterno = apellidoPaterno;
//		this.apellidoMaterno = apellidoMaterno;
//		this.fechaNacimiento = fechaNacimiento;
//		this.ingresos = ingresos;
//		this.codigoPostal = codigoPostal;
//	}
//	
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//    private Long id;
//	
//	@Column(name="nombre")
//    private String nombre;
//	
//	@Column(name="apellido_paterno")
//    private String apellidoPaterno;
//	
//	@Column(name="apellido_materno")
//    private String apellidoMaterno;
//	
//	@Column(name="fecha_nacimiento")
//    private Date fechaNacimiento;
//	
//	@Column(name="ingresos")
//    private Integer ingresos;
//	
//	@Column(name="codigo_postal")
//    private String codigoPostal;
//	
//
//	
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public String getApellidoPaterno() {
//		return apellidoPaterno;
//	}
//
//	public void setApellidoPaterno(String apellidoPaterno) {
//		this.apellidoPaterno = apellidoPaterno;
//	}
//
//	public String getApellidoMaterno() {
//		return apellidoMaterno;
//	}
//
//	public void setApellidoMaterno(String apellidoMaterno) {
//		this.apellidoMaterno = apellidoMaterno;
//	}
//
//	public Date getFechaNacimiento() {
//		return fechaNacimiento;
//	}
//
//	public void setFechaNacimiento(Date fechaNacimiento) {
//		this.fechaNacimiento = fechaNacimiento;
//	}
//
//	public Integer getIngresos() {
//		return ingresos;
//	}
//
//	public void setIngresos(Integer ingresos) {
//		this.ingresos = ingresos;
//	}
//
//	public String getCodigoPostal() {
//		return codigoPostal;
//	}
//
//	public void setCodigoPostal(String codigoPostal) {
//		this.codigoPostal = codigoPostal;
//	}
//	
//	@Override
//	public String toString() {
//		return "Cliente [id=" + id + ", nombre=" 
//	+ nombre + ", apellidoPaterno=" 
//	+ apellidoPaterno + ", apellidoMaterno=" 
//	+ apellidoMaterno + ", fechaNacimiento=" 
//	+ fechaNacimiento + ", ingresos=" 
//	+ ingresos + ", codigoPostal=" 
//	+ codigoPostal 
//				+ "]";
//	}
//	
//
//
//}
