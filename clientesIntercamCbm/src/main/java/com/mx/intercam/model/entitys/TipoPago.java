package com.mx.intercam.model.entitys;

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
@Table(name=TipoPago.TABLE_NAME)
@Getter
@Setter
public class TipoPago {
	public static final String TABLE_NAME= "BDTipo_Pago";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Tpa_Id")
	private Integer tpaId;
	
	@Column(name="Tpa_Descripcion")
	private String tapDescripcion;
	
	@Column(name="Tpa_Estatus")
	private Short tpaEstatus;
	
	@Column(name="Tpa_FHEstatus")
	private Date tpaFHEstatus;
	
	@Column(name="Tpa_Causa_Estatus")
	private String tpaCausaEstatus;
	
	@Column(name="Tpa_UsuAlta")
	private String tpaUsuAlta;
	
	@Column(name="Tpa_FHAlta")
	private Date tpaFHAlta;
	
	@Column(name="Tpa_UsuModifica")
	private String tpaUsuModifica;
	
	@Column(name="Tpa_FHModifica")
	private Date tpaFHModifica;
	
	@Column(name="Tpa_Observaciones")
	private String tpaObservaciones;
}
