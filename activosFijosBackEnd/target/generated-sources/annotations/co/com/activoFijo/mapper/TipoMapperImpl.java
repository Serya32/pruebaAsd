package co.com.activoFijo.mapper;

import co.com.activoFijo.dto.TipoDTO;
import co.com.activoFijo.entity.Tipo;
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
public class TipoMapperImpl implements TipoMapper {

    @Override
    public Tipo TipoDTOToTipo(TipoDTO tipoDTO) {
        if ( tipoDTO == null ) {
            return null;
        }

        Tipo tipo = new Tipo();

        tipo.setId( tipoDTO.getId() );
        tipo.setNombre( tipoDTO.getNombre() );

        return tipo;
    }

    @Override
    public TipoDTO TipoToTipoDTO(Tipo tipo) {
        if ( tipo == null ) {
            return null;
        }

        TipoDTO tipoDTO = new TipoDTO();

        tipoDTO.setId( tipo.getId() );
        tipoDTO.setNombre( tipo.getNombre() );

        return tipoDTO;
    }

    @Override
    public List<TipoDTO> TipoListToTipoDTOList(List<Tipo> tipoList) {
        if ( tipoList == null ) {
            return null;
        }

        List<TipoDTO> list = new ArrayList<TipoDTO>( tipoList.size() );
        for ( Tipo tipo : tipoList ) {
            list.add( TipoToTipoDTO( tipo ) );
        }

        return list;
    }
}
