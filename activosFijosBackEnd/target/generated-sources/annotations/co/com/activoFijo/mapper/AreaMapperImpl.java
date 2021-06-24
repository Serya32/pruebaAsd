package co.com.activoFijo.mapper;

import co.com.activoFijo.dto.AreaDTO;
import co.com.activoFijo.entity.Area;
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
public class AreaMapperImpl implements AreaMapper {

    @Override
    public Area AreaDTOToArea(AreaDTO areaDTO) {
        if ( areaDTO == null ) {
            return null;
        }

        Area area = new Area();

        area.setId( areaDTO.getId() );
        area.setIdCiudad( areaDTO.getIdCiudad() );
        area.setNombre( areaDTO.getNombre() );

        return area;
    }

    @Override
    public AreaDTO AreaToAreaDTO(Area area) {
        if ( area == null ) {
            return null;
        }

        AreaDTO areaDTO = new AreaDTO();

        areaDTO.setId( area.getId() );
        areaDTO.setIdCiudad( area.getIdCiudad() );
        areaDTO.setNombre( area.getNombre() );

        return areaDTO;
    }

    @Override
    public List<AreaDTO> AreaListToAreaDTOList(List<Area> areaList) {
        if ( areaList == null ) {
            return null;
        }

        List<AreaDTO> list = new ArrayList<AreaDTO>( areaList.size() );
        for ( Area area : areaList ) {
            list.add( AreaToAreaDTO( area ) );
        }

        return list;
    }
}
