package co.com.activoFijo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.entity.ActivoFijo;

@Mapper(componentModel = "spring")
public interface ActivoFijoMapper {

	ActivoFijoMapper INSTANCE = Mappers.getMapper(ActivoFijoMapper.class);
	
	/**
	 * Mapea ActivoFijoDTO a ActivoFijo entity
	 * 
	 * @param ActivoFijoDTO
	 * @return ActivoFijo entity
	 */
	ActivoFijo activoFijoDTOToActivoFijo(ActivoFijoDTO activoFijoDTO);

	/**
	 * Mapea ActivoFijo entity a ActivoFijoDTO
	 * 
	 * @param ActivoFijo entity
	 * @return ActivoFijoDTO
	 */
	ActivoFijoDTO ActivoFijoToactivoFijoDTO(ActivoFijo activoFijo);
	
	/**
	 * Mapea ActivoFijoList a ActivoFijoDTOList
	 * 
	 * @param activoFijoList
	 * @return ActivoFijoDTO list
	 */
	List<ActivoFijoDTO> activoFijoListToActivoFijoDTOList(List<ActivoFijo> activoFijoArray);

}