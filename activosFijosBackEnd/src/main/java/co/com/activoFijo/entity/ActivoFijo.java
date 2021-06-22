package co.com.activoFijo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ActivoFijo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer idTipo;
	private Integer idAsignacion;
//	private String nombre;
//	private String descripcion;
//	private String serial;
//	private Long numeroInternoInventario;
//	private Double peso;
//	private Double alto;
//	private Double ancho;
//	private Double largo;
//	private Long valorCompra;
//	private Date fechaCompra;

	protected ActivoFijo() {
	}

	public ActivoFijo(Integer idTipo, Integer idAsignacion) {
		this.idTipo = idTipo;
		this.idAsignacion = idAsignacion;
//		this.nombre = nombre;
//		this.descripcion = descripcion;
//		this.serial = serial;
//		this.numeroInternoInventario = numeroInternoInventario;
//		this.peso = peso;
//		this.alto = alto;
//		this.ancho = ancho;
//		this.largo = largo;
//		this.valorCompra = valorCompra;
//		this.fechaCompra = fechaCompra;

	}

}
