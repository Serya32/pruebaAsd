package co.com.activoFijo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.activoFijo.dto.AreaDTO;
import co.com.activoFijo.entity.Area;

@Mapper(componentModel = "spring")
public interface AreaMapper {
	AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);

	/**
	 * Mapea AreaDTO a Area entity
	 * 
	 * @param AreaDTO
	 * @return Area entity
	 */
	Area AreaDTOToArea(AreaDTO areaDTO);
	
	/**
	 * Mapea Area a AreaDTO entity
	 * 
	 * @param Area
	 * @return AreaDTO entity
	 */
	AreaDTO AreaToAreaDTO(Area area);
	
	/**
	 * Mapea AreaList a AreaDTOList
	 * 
	 * @param AreaList
	 * @return AreaDTO list
	 */
	List<AreaDTO> AreaListToAreaDTOList(List<Area> areaList);

}
