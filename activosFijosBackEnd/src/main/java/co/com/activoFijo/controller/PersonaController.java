package co.com.activoFijo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.activoFijo.entity.Persona;
import co.com.activoFijo.services.IPersonaService;

@RestController("persona")
@CrossOrigin(origins = "*")
public class PersonaController {

	@Autowired
	IPersonaService personaService;

	@GetMapping(value = {"/api/getPersona"}, produces = "application/json")
	public ResponseEntity<List<Persona>> getPersona() {
		try {
			return new ResponseEntity<>(personaService.getPersonas(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
