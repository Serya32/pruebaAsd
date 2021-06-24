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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer idCiudad;
	private String nombre;
	
	public Area() {
	}

	public Area(Integer String, Integer idCiudad, String nombre) {
		this.id = String;
		this.idCiudad = idCiudad;
		this.nombre = nombre;
	}
}
