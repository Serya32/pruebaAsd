package co.com.activoFijo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.entity.ActivoFijo;
import co.com.activoFijo.services.IActivoFijoService;

@RestController
@CrossOrigin(origins = "*")
public class ActivoFijoController {

	@Autowired
	IActivoFijoService activoFijoService;
	
	@RequestMapping("holaMundo")
	public List<ActivoFijo> holaMundo() {
		return activoFijoService.holaMundo();
		
	}
}
