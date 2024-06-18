package edu.AvaliadorFilmesSeries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AvaliadorFilmesSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliadorFilmesSeriesApplication.class, args);
	}

}
