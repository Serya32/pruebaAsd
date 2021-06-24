package co.com.activoFijo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.activoFijo.dto.TipoDTO;
import co.com.activoFijo.entity.Tipo;

@Mapper(componentModel = "spring")
public interface TipoMapper {
	
	TipoMapper INSTANCE = Mappers.getMapper(TipoMapper.class);

	/**
	 * Mapea TipoDTO a Tipo entity
	 * 
	 * @param TipoDTO
	 * @return Tipo entity
	 */
	Tipo TipoDTOToTipo(TipoDTO tipoDTO);
	
	/**
	 * Mapea Tipo a TipoDTO entity
	 * 
	 * @param Tipo
	 * @return TipoDTO entity
	 */
	TipoDTO TipoToTipoDTO(Tipo tipo);
	
	/**
	 * Mapea TipoList a TipoDTOList
	 * 
	 * @param tipoList
	 * @return TipoDTO list
	 */
	List<TipoDTO> TipoListToTipoDTOList(List<Tipo> tipoList);
}
