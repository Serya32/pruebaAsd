package co.com.activoFijo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ActivoFijo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idTipo;
	private Integer idArea;
	private Integer idPersona;
	private Integer idCiudad;
	private String nombre;
	private String descripcion;
	private String serial;
	private Long numeroInternoInventario;
	private Double peso;
	private Double alto;
	private Double ancho;
	private Double largo;
	private Long valorCompra;
	private Date fechaCompra;

	public ActivoFijo() {
	}

	public ActivoFijo(Integer idTipo, Integer idArea, Integer idPersona, Integer idCiudad,
			String nombre, String descripcion, String serial, Long numeroInternoInventario, Double peso,
			Double alto, Double ancho, Double largo, Long valorCompra, Date fechaCompra) {
		this.idTipo = idTipo;
		this.idArea = idArea;
		this.idPersona = idPersona;
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.serial = serial;
		this.numeroInternoInventario = numeroInternoInventario;
		this.peso = peso;
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
		this.valorCompra = valorCompra;
		this.fechaCompra = fechaCompra;

	}

}
