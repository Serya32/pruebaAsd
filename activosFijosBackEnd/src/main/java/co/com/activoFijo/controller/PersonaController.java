package co.com.activoFijo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.activoFijo.dto.PersonaDTO;
import co.com.activoFijo.entity.Ciudad;
import co.com.activoFijo.services.IPersonaService;

@RestController("persona")
@CrossOrigin(origins = "*")
public class PersonaController {

	private static final Logger logger = LoggerFactory.getLogger(Ciudad.class);

	@Autowired
	IPersonaService personaService;

	@GetMapping(value = {"/api/getPersona"}, produces = "application/json")
	public ResponseEntity<List<PersonaDTO>> getPersona() {
		logger.info("getPersona");
		try {
			return new ResponseEntity<>(personaService.getPersona(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
