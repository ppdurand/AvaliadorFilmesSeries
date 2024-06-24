package edu.AvaliadorFilmesSeries.controller;

import edu.AvaliadorFilmesSeries.model.Log;
import edu.AvaliadorFilmesSeries.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping()
    public ResponseEntity<List<Log>> getAllLogs(){
        return logService.getAll();
    }
    @PostMapping("/newLog/{title}")
    public void postLog(@PathVariable("title") String title, @RequestParam("stars") int stars,
                     @RequestParam("critic") String critic, @RequestParam("userId") int userId){
        logService.create(title, stars, critic, userId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLog(@PathVariable("id") int id){
        this.logService.delete(id);
    }
}
