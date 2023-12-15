package map.project.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"map.project.demo.entities"})
@EntityScan(basePackages = {"map.project.demo.entities", "map.project.demo.repositories", "map.project.demo.controllers", "map.project.demo.service","map.project.demo.entities.Patterns"})
//@EnableJpaRepositories(basePackages = "map.project.demo.repositories")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
