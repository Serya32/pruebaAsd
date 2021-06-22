package co.com.activoFijo.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.entity.ActivoFijo;
import co.com.activoFijo.repository.ActivoFijoRepository;
import co.com.activoFijo.services.IActivoFijoService;

@Service
public class ActivoFijoService implements IActivoFijoService {
	
	@Autowired
	ActivoFijoRepository activoFijoRepository;
	
	public List<ActivoFijo> holaMundo() {
		
		Iterable<ActivoFijo> respuesta = activoFijoRepository.findAll();
		List<ActivoFijo> actualList = StreamSupport
				  .stream(respuesta.spliterator(), false)
				  .collect(Collectors.toList());
		
		return actualList;
	}
}
