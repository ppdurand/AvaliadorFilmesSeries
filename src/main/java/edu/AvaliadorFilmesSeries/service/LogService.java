package edu.AvaliadorFilmesSeries.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.AvaliadorFilmesSeries.client.OmdbApiClient;
import edu.AvaliadorFilmesSeries.model.Log;
import edu.AvaliadorFilmesSeries.model.Movie;
import edu.AvaliadorFilmesSeries.repository.LogRepository;
import edu.AvaliadorFilmesSeries.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements IService<Log> {

    @Autowired
    private OmdbApiClient omdbApiClient;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${omdb.api.key}")
    private String apiKey;

    @Override
    public ResponseEntity<List<Log>> getAll() {
        List<Log> response = logRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(logRepository.findAll());
    }

    public void create(String movieTitle, int stars, String critic){
        try{
            ResponseEntity<String> response = omdbApiClient.searchByTitle(movieTitle, apiKey);
            String responseBody = response.getBody();

            ObjectMapper mapper = new ObjectMapper();
            Movie movie = mapper.readValue(responseBody, Movie.class);

            if(stars > 10){
                throw new IllegalArgumentException("A avaliação deve ser de 0 à 10 estrelas");
            }

            Log log = new Log(stars, movie, critic);

            logRepository.save(log);


        } catch (JsonProcessingException e){
            System.out.println("Erro ao desserializar o Json: " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id){
        logRepository.deleteById(id);
    }
}
