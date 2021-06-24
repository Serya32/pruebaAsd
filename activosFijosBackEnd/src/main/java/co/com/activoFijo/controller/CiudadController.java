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

import co.com.activoFijo.dto.CiudadDTO;
import co.com.activoFijo.entity.Ciudad;
import co.com.activoFijo.services.ICiudadService;

@RestController("ciudad")
@CrossOrigin(origins = "*")
public class CiudadController {
	private static final Logger logger = LoggerFactory.getLogger(Ciudad.class);

	@Autowired
	ICiudadService ciudadService;
	
	@GetMapping(value = {"/api/getCiudad"}, produces = "application/json")
	public ResponseEntity<List<CiudadDTO>> getCiudad(	) {
		logger.info("getCiudad");
		try {
			return new ResponseEntity<>(ciudadService.getCiudad(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
