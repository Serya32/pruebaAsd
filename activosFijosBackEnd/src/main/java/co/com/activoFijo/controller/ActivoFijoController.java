package co.com.activoFijo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.entity.ActivoFijo;
import co.com.activoFijo.exception.SaveException;
import co.com.activoFijo.services.IActivoFijoService;

@RestController("activos-fijos")
@CrossOrigin(origins = "*")
public class ActivoFijoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ActivoFijo.class);

	@Autowired
	IActivoFijoService activoFijoService;

	@GetMapping(value = {"/api/getActivosFijos"}, produces = "application/json")
	public ResponseEntity<List<ActivoFijoDTO>> getActivosFijos(	) {
		logger.info("getActivosFijos");
		try {
			return new ResponseEntity<>(activoFijoService.getActivosFijos(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = {"/api/getActivoFijo/{id}"}, produces = "application/json")
	public ResponseEntity<ActivoFijoDTO> getActivoFijo(@PathVariable(name = "id") Integer id) {
		logger.info("getActivoFijo");
		try {
			return new ResponseEntity<>(activoFijoService.getActivoFijo(id), HttpStatus.OK);
		} catch (SaveException e) {
			logger.error("save - SaveException: {}", e);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = {"/api/saveActivo"}, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ActivoFijoDTO> save(@RequestBody ActivoFijoDTO activoFijoDTO) {
		logger.info("save - activoFijoDTO: {}", activoFijoDTO);

		try {
			return new ResponseEntity<>(activoFijoService.save(activoFijoDTO), HttpStatus.OK);
		} catch (SaveException e) {
			logger.error("save - SaveException: {}", e);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			logger.error("save - error: {}", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
