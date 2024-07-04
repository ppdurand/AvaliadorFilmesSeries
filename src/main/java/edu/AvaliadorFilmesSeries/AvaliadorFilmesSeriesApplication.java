package edu.AvaliadorFilmesSeries;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Avaliador Filmes e Séries", version = "1",
					description = "Sistema de avaliação de obras cinematográficas"))
@EnableFeignClients
public class AvaliadorFilmesSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliadorFilmesSeriesApplication.class, args);
	}

}
