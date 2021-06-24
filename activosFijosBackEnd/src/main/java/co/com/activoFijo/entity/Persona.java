package co.com.activoFijo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombres;
	private String apellidos;
	
	public Persona() {
	}

	public Persona(String nombres, String apellidos) {
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

}
