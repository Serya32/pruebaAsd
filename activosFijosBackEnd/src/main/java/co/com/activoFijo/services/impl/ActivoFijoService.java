package co.com.activoFijo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.entity.ActivoFijo;
import co.com.activoFijo.exception.SaveException;
import co.com.activoFijo.mapper.ActivoFijoMapper;
import co.com.activoFijo.repository.ActivoFijoRepository;
import co.com.activoFijo.services.IActivoFijoService;

@Service
public class ActivoFijoService implements IActivoFijoService {
	
	@Autowired
	ActivoFijoRepository activoFijoRepository;
	
	@Autowired
	ActivoFijoMapper activoFijoMapper;
	
	@Override
	public List<ActivoFijoDTO> getActivosFijos() {
		
		Iterable<ActivoFijo> respuesta = activoFijoRepository.findAll();
		List<ActivoFijo> actualList = StreamSupport
				  .stream(respuesta.spliterator(), false)
				  .collect(Collectors.toList());
		List<ActivoFijoDTO> listActivoFijo = activoFijoMapper.activoFijoListToActivoFijoDTOList(actualList);
		
		return listActivoFijo;
	}

	@Override
	public ActivoFijoDTO save(ActivoFijoDTO activoFijoDTO) throws SaveException {
		
		ActivoFijo activoFijo = activoFijoMapper.activoFijoDTOToActivoFijo(activoFijoDTO);
		ActivoFijoDTO response = new ActivoFijoDTO();
		try {
			response = activoFijoMapper.ActivoFijoToactivoFijoDTO(activoFijoRepository.save(activoFijo));
			
		} catch (Exception e) {
			throw new SaveException("Error guardando en DB.");
		}
		
		return response;
	}

	@Override
	public ActivoFijoDTO getActivoFijo(Integer id) throws SaveException {
			Optional<ActivoFijo> activoFijoOpt = activoFijoRepository.findById(id);
			if (activoFijoOpt.isPresent()) {
				ActivoFijo activoFijo = activoFijoOpt.get();
				return activoFijoMapper.ActivoFijoToactivoFijoDTO(activoFijo);
			} else {
				
				throw new SaveException("Error Actualizando.");
			}
		
	}
}
