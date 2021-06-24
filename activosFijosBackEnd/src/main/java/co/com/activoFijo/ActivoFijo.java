package co.com.activoFijo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.activoFijo.entity.Area;
import co.com.activoFijo.entity.Tipo;
import co.com.activoFijo.repository.ActivoFijoRepository;
import co.com.activoFijo.repository.AreaRepository;
import co.com.activoFijo.repository.TipoRepository;

@SpringBootApplication
public class ActivoFijo {
	private static final Logger logger = LoggerFactory.getLogger(ActivoFijo.class);

	public static void main(String[] args) {
		SpringApplication.run(ActivoFijo.class, args);
	}

	@Bean
	public CommandLineRunner bd(ActivoFijoRepository repository, TipoRepository tipoRepository, AreaRepository areaRepository) {
		return (args) -> {
			// Se guardan en DB activos fijos iniciales
			crearActivosFijos(repository);
			// Se guardan en DB tipos iniciales
			crearTipos(tipoRepository);
			// Se guardan en DB areas iniciales
			crearAreas(areaRepository);
		};
	}

	private void crearActivosFijos(ActivoFijoRepository repository) {
		repository.save(new co.com.activoFijo.entity.ActivoFijo(11, 11));
		repository.save(new co.com.activoFijo.entity.ActivoFijo(12, 11));
		repository.save(new co.com.activoFijo.entity.ActivoFijo(13, 11));
	}

	private void crearTipos(TipoRepository tipoRepository) {
		tipoRepository.save(new Tipo(1, "Mesa"));
		tipoRepository.save(new Tipo(2, "Silla"));
		tipoRepository.save(new Tipo(3, "Esfero"));
	}
	
	private void crearAreas(AreaRepository areaRepository) {
		areaRepository.save(new Area(1, 2, "Mercadeo"));
		areaRepository.save(new Area(2, 5, "Ingenieria"));
		areaRepository.save(new Area(3, 1, "Tecnologia"));
	}


}
