package co.com.activoFijo.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.activoFijo.dto.TipoDTO;
import co.com.activoFijo.entity.Tipo;
import co.com.activoFijo.mapper.TipoMapper;
import co.com.activoFijo.repository.TipoRepository;
import co.com.activoFijo.services.ITipoService;

@Service
public class TipoService implements ITipoService{
	@Autowired
	TipoRepository tipoRepository;
	
	@Autowired
	TipoMapper tipoMapper;
	
	@Override
	public List<TipoDTO> getTipos() {
		Iterable<Tipo> respuesta = tipoRepository.findAll();
		List<Tipo> tipoList = StreamSupport
				  .stream(respuesta.spliterator(), false)
				  .collect(Collectors.toList());
		List<TipoDTO> tipoDTO = tipoMapper.TipoListToTipoDTOList(tipoList);
		
		return tipoDTO;
	}

}
