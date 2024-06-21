package edu.AvaliadorFilmesSeries.service;

import edu.AvaliadorFilmesSeries.dto.EditUserDTO;
import edu.AvaliadorFilmesSeries.model.User;
import edu.AvaliadorFilmesSeries.repository.UserRepository;
import edu.AvaliadorFilmesSeries.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    public void create(String name, String bio){
        User user = new User(name, bio);
        this.userRepository.save(user);
    }

    public void update(int id, String name, String bio){
        EditUserDTO editUser = new EditUserDTO(name, bio);

        this.userRepository.findById(id).map(user -> {
            this.userRepository.save(editUser.toUser(user));
            return null;
        });
    }

    @Override
    public void delete(int id){
        userRepository.deleteById(id);
    }
}
