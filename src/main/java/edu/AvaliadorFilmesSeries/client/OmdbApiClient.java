package edu.AvaliadorFilmesSeries.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "omdbClient", url = "http://www.omdbapi.com")
public interface OmdbApiClient {
    @GetMapping("/?apikey={apikey}&t={title}")
    ResponseEntity<String> searchByTitle(@PathVariable("title") String title,
            @PathVariable("apikey")String apiKey);
}
