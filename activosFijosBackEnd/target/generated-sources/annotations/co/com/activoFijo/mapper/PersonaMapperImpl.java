package co.com.activoFijo.mapper;

import co.com.activoFijo.dto.PersonaDTO;
import co.com.activoFijo.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-23T23:51:59-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public Persona PersonaDTOToPersona(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setApellidos( personaDTO.getApellidos() );
        persona.setId( personaDTO.getId() );
        persona.setNombres( personaDTO.getNombres() );

        return persona;
    }

    @Override
    public PersonaDTO PersonaToPersonaDTO(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setApellidos( persona.getApellidos() );
        personaDTO.setId( persona.getId() );
        personaDTO.setNombres( persona.getNombres() );

        return personaDTO;
    }

    @Override
    public List<PersonaDTO> PersonaListToPersonaDTOList(List<Persona> personaList) {
        if ( personaList == null ) {
            return null;
        }

        List<PersonaDTO> list = new ArrayList<PersonaDTO>( personaList.size() );
        for ( Persona persona : personaList ) {
            list.add( PersonaToPersonaDTO( persona ) );
        }

        return list;
    }
}
