package api.events.project.apieventsproject.controller;
import api.events.project.apieventsproject.entity.Role;
import api.events.project.apieventsproject.entity.RoleName;
import api.events.project.apieventsproject.entity.User;
import api.events.project.apieventsproject.message.request.JsonResponseCreate;
import api.events.project.apieventsproject.message.request.LoginForm;
import api.events.project.apieventsproject.message.request.SignUpForm;
import api.events.project.apieventsproject.message.response.JwtResponse;
import api.events.project.apieventsproject.repository.RoleRepository;
import api.events.project.apieventsproject.repository.UserRepository;
import api.events.project.apieventsproject.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<JsonResponseCreate> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new JsonResponseCreate(true,"Fail -> Username is already taken!","error"),HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new JsonResponseCreate(true,"Fail -> Email is already in use!","error"),HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);
        return new ResponseEntity<>(new JsonResponseCreate(true,"User registered successfully!","OK"), HttpStatus.OK);

    }
}