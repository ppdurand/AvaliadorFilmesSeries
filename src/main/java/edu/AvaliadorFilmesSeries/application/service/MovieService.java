package edu.AvaliadorFilmesSeries.application.service;

import edu.AvaliadorFilmesSeries.infra.client.OmdbApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private OmdbApiClient omdbApiClient;

    @Value("${omdb.api.key}")
    private String apiKey;

    public ResponseEntity<String> getMovieBytitle(String title){
        ResponseEntity<String> response = omdbApiClient.searchByTitle(title, apiKey);
        return response;
    }
}
