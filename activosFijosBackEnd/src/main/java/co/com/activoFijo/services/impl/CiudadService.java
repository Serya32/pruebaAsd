package co.com.activoFijo.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.activoFijo.dto.CiudadDTO;
import co.com.activoFijo.entity.Ciudad;
import co.com.activoFijo.mapper.CiudadMapper;
import co.com.activoFijo.repository.CiudadRepository;
import co.com.activoFijo.services.ICiudadService;

@Service
public class CiudadService implements ICiudadService{

	@Autowired
	CiudadRepository ciudadRepository ;
	
	@Autowired
	CiudadMapper ciudadMapper;
	
	@Override
	public List<CiudadDTO> getCiudad() {
		Iterable<Ciudad> respuesta = ciudadRepository.findAll();
		List<Ciudad> ciudadList = StreamSupport
				  .stream(respuesta.spliterator(), false)
				  .collect(Collectors.toList());
		List<CiudadDTO> ciudadDTO = ciudadMapper.CiudadListToCiudadDTOList(ciudadList);
		
		return ciudadDTO;
	}
}
