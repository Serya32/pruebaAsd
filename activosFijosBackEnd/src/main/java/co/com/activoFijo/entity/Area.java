package co.com.activoFijo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idCiudad;
	private String nombre;
	
	public Area() {
	}

	public Area(Integer idCiudad, String nombre) {
		this.idCiudad = idCiudad;
		this.nombre = nombre;
	}
}
