package co.com.activoFijo.mapper;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.entity.ActivoFijo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-24T02:18:48-0500",
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

        activoFijo.setAlto( activoFijoDTO.getAlto() );
        activoFijo.setAncho( activoFijoDTO.getAncho() );
        activoFijo.setDescripcion( activoFijoDTO.getDescripcion() );
        activoFijo.setFechaCompra( activoFijoDTO.getFechaCompra() );
        activoFijo.setId( activoFijoDTO.getId() );
        activoFijo.setIdArea( activoFijoDTO.getIdArea() );
        activoFijo.setIdCiudad( activoFijoDTO.getIdCiudad() );
        activoFijo.setIdPersona( activoFijoDTO.getIdPersona() );
        activoFijo.setIdTipo( activoFijoDTO.getIdTipo() );
        activoFijo.setLargo( activoFijoDTO.getLargo() );
        activoFijo.setNombre( activoFijoDTO.getNombre() );
        activoFijo.setNumeroInternoInventario( activoFijoDTO.getNumeroInternoInventario() );
        activoFijo.setPeso( activoFijoDTO.getPeso() );
        activoFijo.setSerial( activoFijoDTO.getSerial() );
        activoFijo.setValorCompra( activoFijoDTO.getValorCompra() );

        return activoFijo;
    }

    @Override
    public ActivoFijoDTO ActivoFijoToactivoFijoDTO(ActivoFijo activoFijo) {
        if ( activoFijo == null ) {
            return null;
        }

        ActivoFijoDTO activoFijoDTO = new ActivoFijoDTO();

        activoFijoDTO.setAlto( activoFijo.getAlto() );
        activoFijoDTO.setAncho( activoFijo.getAncho() );
        activoFijoDTO.setDescripcion( activoFijo.getDescripcion() );
        activoFijoDTO.setFechaCompra( activoFijo.getFechaCompra() );
        activoFijoDTO.setId( activoFijo.getId() );
        activoFijoDTO.setIdArea( activoFijo.getIdArea() );
        activoFijoDTO.setIdCiudad( activoFijo.getIdCiudad() );
        activoFijoDTO.setIdPersona( activoFijo.getIdPersona() );
        activoFijoDTO.setIdTipo( activoFijo.getIdTipo() );
        activoFijoDTO.setLargo( activoFijo.getLargo() );
        activoFijoDTO.setNombre( activoFijo.getNombre() );
        activoFijoDTO.setNumeroInternoInventario( activoFijo.getNumeroInternoInventario() );
        activoFijoDTO.setPeso( activoFijo.getPeso() );
        activoFijoDTO.setSerial( activoFijo.getSerial() );
        activoFijoDTO.setValorCompra( activoFijo.getValorCompra() );

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
