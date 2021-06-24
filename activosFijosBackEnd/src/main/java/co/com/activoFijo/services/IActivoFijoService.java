package co.com.activoFijo.services;

import java.util.List;

import co.com.activoFijo.dto.ActivoFijoDTO;
import co.com.activoFijo.exception.SaveException;

public interface IActivoFijoService {
	
	List<ActivoFijoDTO> getActivosFijos();

	ActivoFijoDTO save(ActivoFijoDTO activoFijoDTO) throws SaveException;

	ActivoFijoDTO getActivoFijo(Integer id) throws SaveException;
}
