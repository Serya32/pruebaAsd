package co.com.activoFijo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.activoFijo.repository.ActivoFijoRepository;

@SpringBootApplication
public class ActivoFijo {
	private static final Logger log = LoggerFactory.getLogger(ActivoFijo.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ActivoFijo.class, args);
	}
	
	@Bean
	public CommandLineRunner bd(ActivoFijoRepository repository) {
		return(args) -> {
			// save a few customers
		      repository.save(new co.com.activoFijo.entity.ActivoFijo(11, 11));
		      repository.save(new co.com.activoFijo.entity.ActivoFijo(12, 11));
		      repository.save(new co.com.activoFijo.entity.ActivoFijo(13, 11));
		      
		    // fetch all customers
		      log.info("Customers found with findAll():");
		      log.info("-------------------------------");
		      
		      for (co.com.activoFijo.entity.ActivoFijo activoFijo : repository.findAll()) {
		          log.info(activoFijo.toString());
		        }
		        log.info("");
		};
	}

}
