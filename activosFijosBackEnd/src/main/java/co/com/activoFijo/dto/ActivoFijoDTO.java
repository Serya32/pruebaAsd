package co.com.activoFijo.dto;


import lombok.Data;

import java.util.Date;


@Data
public class ActivoFijoDTO {
	private Integer id;
	private Integer idTipo;
	private Integer idAsignacion;
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
}
