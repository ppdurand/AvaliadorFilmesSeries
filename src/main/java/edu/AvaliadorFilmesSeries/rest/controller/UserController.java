package edu.AvaliadorFilmesSeries.rest.controller;

import edu.AvaliadorFilmesSeries.domain.model.User;
import edu.AvaliadorFilmesSeries.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAll();
    }

//    @PostMapping("/new")
//    public void postUser(@RequestParam("name") String name, @RequestParam("bio") String bio){
//        userService.create(name, bio);
//    }

    @PutMapping("/edit/{id}")
    public void updateUser(@PathVariable("id") int id, @RequestParam("name") String name,
                           @RequestParam("bio") String bio){
        userService.update(id, name, bio);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.delete(id);
    }
}
