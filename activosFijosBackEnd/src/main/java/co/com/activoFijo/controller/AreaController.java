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

import co.com.activoFijo.dto.AreaDTO;
import co.com.activoFijo.dto.TipoDTO;
import co.com.activoFijo.entity.ActivoFijo;
import co.com.activoFijo.services.IAreaService;
import co.com.activoFijo.services.ITipoService;

@RestController("area")
@CrossOrigin(origins = "*")
public class AreaController {
	
	private static final Logger logger = LoggerFactory.getLogger(ActivoFijo.class);
	
	@Autowired
	IAreaService areaService;
	
	@GetMapping(value = {"/api/getAreas"}, produces = "application/json")
	public ResponseEntity<List<AreaDTO>> getAreas(	) {
		logger.info("getTipos");
		try {
			return new ResponseEntity<>(areaService.getAreas(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
