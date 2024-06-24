package edu.AvaliadorFilmesSeries.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.AvaliadorFilmesSeries.client.OmdbApiClient;
import edu.AvaliadorFilmesSeries.model.Log;
import edu.AvaliadorFilmesSeries.model.Movie;
import edu.AvaliadorFilmesSeries.model.User;
import edu.AvaliadorFilmesSeries.repository.LogRepository;
import edu.AvaliadorFilmesSeries.repository.UserRepository;
import edu.AvaliadorFilmesSeries.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService implements IService<Log> {

    @Autowired
    private OmdbApiClient omdbApiClient;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Value("${omdb.api.key}")
    private String apiKey;

    @Override
    public ResponseEntity<List<Log>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(logRepository.findAll());
    }

    public void create(String movieTitle, int stars, String critic, int userId){
        try{
            ResponseEntity<String> response = omdbApiClient.searchByTitle(movieTitle, apiKey);
            String responseBody = response.getBody();

            Movie movie = objectMapper.readValue(responseBody, Movie.class);

            if(stars > 10){
                throw new IllegalArgumentException("A avaliação deve ser de 0 à 10 estrelas");
            }

            Optional<User> optionalUser = userRepository.findById(userId);
            if(optionalUser.isPresent()){
                Log log = new Log(stars, critic, movie, optionalUser.get());
                optionalUser.get().setLog(log);
                logRepository.save(log);
            }
            else{
                throw new Exception("Usuário não encontrado/Não existe");
            }


        } catch (JsonProcessingException e){
            System.out.println("Erro ao desserializar o Json: " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id){
        logRepository.deleteById(id);
    }
}
