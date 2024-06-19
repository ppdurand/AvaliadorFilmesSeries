package edu.AvaliadorFilmesSeries.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.AvaliadorFilmesSeries.client.OmdbApiClient;
import edu.AvaliadorFilmesSeries.model.Log;
import edu.AvaliadorFilmesSeries.model.Movie;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class LogService {

    @Autowired
    private OmdbApiClient omdbApiClient;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${omdb.api.key}")
    private String apiKey;

    public void createLog(String movieTitle, int stars, String critic){
        try{
            ResponseEntity<String> response = omdbApiClient.searchByTitle(movieTitle, apiKey);
            String responseBody = response.getBody();

            ObjectMapper mapper = new ObjectMapper();
            Movie movie = mapper.readValue(responseBody, Movie.class);

            if(stars > 10){
                throw new RuntimeException("A avaliação deve ser de 0 à 10 estrelas");
            }

            Log log = new Log(stars, movie, critic);
        } catch (JsonProcessingException e){
            System.out.println("Erro ao desserializar o Json: " + e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
