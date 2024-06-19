package edu.AvaliadorFilmesSeries.controller;

import edu.AvaliadorFilmesSeries.model.Log;
import edu.AvaliadorFilmesSeries.repository.LogRepository;
import edu.AvaliadorFilmesSeries.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return logService.getAllLogs();
    }
    @PostMapping("/newLog/{title}")
    public void postLog(@PathVariable("title") String title, @RequestParam("stars") int stars,
                     @RequestParam("critic") String critic){
        logService.createLog(title, stars, critic);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLog(@PathVariable("id") int id){
        this.logService.deleteLog(id);
    }
}
