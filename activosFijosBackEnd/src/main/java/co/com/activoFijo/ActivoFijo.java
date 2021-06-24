package co.com.activoFijo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.activoFijo.entity.Area;
import co.com.activoFijo.entity.Ciudad;
import co.com.activoFijo.entity.Persona;
import co.com.activoFijo.entity.Tipo;
import co.com.activoFijo.repository.ActivoFijoRepository;
import co.com.activoFijo.repository.AreaRepository;
import co.com.activoFijo.repository.CiudadRepository;
import co.com.activoFijo.repository.PersonaRepository;
import co.com.activoFijo.repository.TipoRepository;

@SpringBootApplication
public class ActivoFijo {
	private static final Logger logger = LoggerFactory.getLogger(ActivoFijo.class);

	public static void main(String[] args) {
		SpringApplication.run(ActivoFijo.class, args);
	}

	@Bean
	public CommandLineRunner bd(ActivoFijoRepository repository, TipoRepository tipoRepository, 
			AreaRepository areaRepository, PersonaRepository personaRepository, CiudadRepository ciudadRepository) {
		return (args) -> {
			// Se guardan en DB activos fijos iniciales
			crearActivosFijos(repository);
			// Se guardan en DB tipos iniciales
			crearTipos(tipoRepository);
			// Se guardan en DB areas iniciales
			crearAreas(areaRepository);
			// Se guardan en DB personas iniciales
			crearPersonas(personaRepository);
			// Se guardan en DB ciudades iniciales
			crearCiudad(ciudadRepository);
		};
	}

	private void crearActivosFijos(ActivoFijoRepository repository) {
		repository.save(new co.com.activoFijo.entity.ActivoFijo(1, 11));
		repository.save(new co.com.activoFijo.entity.ActivoFijo(2, 11));
		repository.save(new co.com.activoFijo.entity.ActivoFijo(3, 11));
	}
	private void crearPersonas(PersonaRepository personaRepository) {
		personaRepository.save(new Persona( "Cristian", "Torres"));
		personaRepository.save(new Persona( "Alejandro", "Arias"));
		personaRepository.save(new Persona("Camilo", "Pedraza"));
		personaRepository.save(new Persona("Felipe", "Rodriguez"));
	}

	private void crearTipos(TipoRepository tipoRepository) {
		tipoRepository.save(new Tipo("Mesa"));
		tipoRepository.save(new Tipo("Silla"));
		tipoRepository.save(new Tipo("Esfero"));
	}
	
	private void crearAreas(AreaRepository areaRepository) {
		areaRepository.save(new Area(2, "Mercadeo"));
		areaRepository.save(new Area(5, "Ingenieria"));
		areaRepository.save(new Area(1, "Tecnologia"));
	}
	
	private void crearCiudad(CiudadRepository ciudadRepository) {
		ciudadRepository.save(new Ciudad("Bogotá"));
		ciudadRepository.save(new Ciudad("Medellin"));
		ciudadRepository.save(new Ciudad("Cali"));
		ciudadRepository.save(new Ciudad("Funza"));
		ciudadRepository.save(new Ciudad("Mosquera"));
	}


}
