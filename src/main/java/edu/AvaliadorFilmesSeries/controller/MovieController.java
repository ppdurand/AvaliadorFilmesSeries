package edu.AvaliadorFilmesSeries.controller;

import edu.AvaliadorFilmesSeries.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/search/{title}")
    public ResponseEntity<String> searchMovieByTitle(@PathVariable("title") String title){
        return movieService.getMovieBytitle(title);
    }
}
