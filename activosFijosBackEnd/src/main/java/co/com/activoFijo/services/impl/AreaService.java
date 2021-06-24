package co.com.activoFijo.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.activoFijo.dto.AreaDTO;
import co.com.activoFijo.entity.Area;
import co.com.activoFijo.mapper.AreaMapper;
import co.com.activoFijo.repository.AreaRepository;
import co.com.activoFijo.services.IAreaService;

@Service
public class AreaService implements IAreaService{

	@Autowired
	AreaRepository areaRepository ;
	
	@Autowired
	AreaMapper areaMapper;
	
	@Override
	public List<AreaDTO> getAreas() {
		Iterable<Area> respuesta = areaRepository.findAll();
		List<Area> areaList = StreamSupport
				  .stream(respuesta.spliterator(), false)
				  .collect(Collectors.toList());
		List<AreaDTO> areaDTO = areaMapper.AreaListToAreaDTOList(areaList);
		
		return areaDTO;
	}
}
