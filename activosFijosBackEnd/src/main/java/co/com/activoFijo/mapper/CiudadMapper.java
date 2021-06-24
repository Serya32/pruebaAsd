package co.com.activoFijo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.activoFijo.dto.CiudadDTO;
import co.com.activoFijo.entity.Ciudad;

@Mapper(componentModel = "spring")
public interface CiudadMapper {
	
	CiudadMapper INSTANCE = Mappers.getMapper(CiudadMapper.class);

	/**
	 * Mapea CiudadDTO a Area Ciudad
	 * 
	 * @param CiudadDTO
	 * @return Ciudad entity
	 */
	Ciudad CiudadDTOToCiudad(CiudadDTO ciudadDTO);
	
	/**
	 * Mapea Ciudad a CiudadDTO 
	 * 
	 * @param Ciudad
	 * @return CiudadDTO 
	 */
	CiudadDTO CiudadToCiudadDTO(Ciudad ciudad);
	
	/**
	 * Mapea CiudadList a CiudadDTOList
	 * 
	 * @param CiudadList
	 * @return CiudadDTO list
	 */
	List<CiudadDTO> CiudadListToCiudadDTOList(List<Ciudad> ciudadList);


}
