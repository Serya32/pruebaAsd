package co.com.activoFijo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.com.activoFijo.dto.PersonaDTO;
import co.com.activoFijo.entity.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
	PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

	/**
	 * Mapea PersonaDTO a Persona entity
	 * 
	 * @param PersonaDTO
	 * @return Persona entity
	 */
	Persona PersonaDTOToPersona(PersonaDTO personaDTO);
	
	/**
	 * Mapea Persona a PersonaDTO
	 * 
	 * @param PersonaDTO
	 * @return Persona entity
	 */
	PersonaDTO PersonaToPersonaDTO(Persona persona);
	
	/**
	 * Mapea PersonaList a PersonaDTOList
	 * 
	 * @param PersonaList
	 * @return PersonaDTOList
	 */
	List<PersonaDTO> PersonaListToPersonaDTOList(List<Persona> personaList);



}
