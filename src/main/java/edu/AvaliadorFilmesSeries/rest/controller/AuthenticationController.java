package edu.AvaliadorFilmesSeries.rest.controller;

import edu.AvaliadorFilmesSeries.application.dto.AuthenticationDTO;
import edu.AvaliadorFilmesSeries.application.dto.LoginResponseDTO;
import edu.AvaliadorFilmesSeries.application.dto.RegisterUserDTO;
import edu.AvaliadorFilmesSeries.domain.model.User;
import edu.AvaliadorFilmesSeries.domain.repository.UserRepository;
import edu.AvaliadorFilmesSeries.infra.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping(value = "/auth", produces = {"application/json"})
@Tag(name = "Avaliador")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
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
