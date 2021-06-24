package co.com.activoFijo.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.activoFijo.entity.Persona;
import co.com.activoFijo.repository.PersonaRepository;
import co.com.activoFijo.services.IPersonaService;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@Override
	public List<Persona> getPersonas() {
		
		Iterable<Persona> personaIterable = personaRepository.findAll();
		List<Persona> personaList = StreamSupport
				  .stream(personaIterable.spliterator(), false)
				  .collect(Collectors.toList());
		
		return personaList;
	}
	
}
