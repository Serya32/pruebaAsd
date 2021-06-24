package co.com.activoFijo.mapper;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.entity.ActivoFijo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-23T19:07:16-0500",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190903-0936, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class ActivoFijoMapperImpl implements ActivoFijoMapper {

    @Override
    public ActivoFijo activoFijoDTOToActivoFijo(ActivoFijoDTO activoFijoDTO) {
        if ( activoFijoDTO == null ) {
            return null;
        }

        ActivoFijo activoFijo = new ActivoFijo();

        activoFijo.setId( activoFijoDTO.getId() );
        activoFijo.setIdAsignacion( activoFijoDTO.getIdAsignacion() );
        activoFijo.setIdTipo( activoFijoDTO.getIdTipo() );

        return activoFijo;
    }

    @Override
    public ActivoFijoDTO ActivoFijoToactivoFijoDTO(ActivoFijo activoFijo) {
        if ( activoFijo == null ) {
            return null;
        }

        ActivoFijoDTO activoFijoDTO = new ActivoFijoDTO();

        activoFijoDTO.setId( activoFijo.getId() );
        activoFijoDTO.setIdAsignacion( activoFijo.getIdAsignacion() );
        activoFijoDTO.setIdTipo( activoFijo.getIdTipo() );

        return activoFijoDTO;
    }

    @Override
    public List<ActivoFijoDTO> activoFijoListToActivoFijoDTOList(List<ActivoFijo> activoFijoArray) {
        if ( activoFijoArray == null ) {
            return null;
        }

        List<ActivoFijoDTO> list = new ArrayList<ActivoFijoDTO>( activoFijoArray.size() );
        for ( ActivoFijo activoFijo : activoFijoArray ) {
            list.add( ActivoFijoToactivoFijoDTO( activoFijo ) );
        }

        return list;
    }
}
