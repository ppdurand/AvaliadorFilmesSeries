package edu.AvaliadorFilmesSeries.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.AvaliadorFilmesSeries.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/get/{title}")
    public void test(@PathVariable("title") String title, @RequestParam("stars") int stars,
                     @RequestParam("critic") String critic){
        logService.createLog(title, stars, critic);
    }
}
