package edu.AvaliadorFilmesSeries.controller;

import edu.AvaliadorFilmesSeries.dto.AuthenticationDTO;
import edu.AvaliadorFilmesSeries.dto.RegisterUserDTO;
import edu.AvaliadorFilmesSeries.model.User;
import edu.AvaliadorFilmesSeries.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok("Logado com Sucesso");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterUserDTO register){
        if (this.userRepository.findByUsername(register.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(register.password());
        User user = new User(register.username(), encryptedPassword, register.role(), register.name(), register.bio());

        this.userRepository.save(user);

        return ResponseEntity.ok("Usuário Registrado Com Sucesso");
    }
}
