package co.com.activoFijo.mapper;

import co.com.activoFijo.dto.CiudadDTO;
import co.com.activoFijo.entity.Ciudad;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-23T21:05:01-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class CiudadMapperImpl implements CiudadMapper {

    @Override
    public Ciudad CiudadDTOToCiudad(CiudadDTO ciudadDTO) {
        if ( ciudadDTO == null ) {
            return null;
        }

        Ciudad ciudad = new Ciudad();

        ciudad.setId( ciudadDTO.getId() );
        ciudad.setNombre( ciudadDTO.getNombre() );

        return ciudad;
    }

    @Override
    public CiudadDTO CiudadToCiudadDTO(Ciudad ciudad) {
        if ( ciudad == null ) {
            return null;
        }

        CiudadDTO ciudadDTO = new CiudadDTO();

        ciudadDTO.setId( ciudad.getId() );
        ciudadDTO.setNombre( ciudad.getNombre() );

        return ciudadDTO;
    }

    @Override
    public List<CiudadDTO> CiudadListToCiudadDTOList(List<Ciudad> ciudadList) {
        if ( ciudadList == null ) {
            return null;
        }

        List<CiudadDTO> list = new ArrayList<CiudadDTO>( ciudadList.size() );
        for ( Ciudad ciudad : ciudadList ) {
            list.add( CiudadToCiudadDTO( ciudad ) );
        }

        return list;
    }
}
