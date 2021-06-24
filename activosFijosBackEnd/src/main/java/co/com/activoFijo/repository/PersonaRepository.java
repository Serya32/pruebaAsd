package co.com.activoFijo.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.activoFijo.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {
	
}
