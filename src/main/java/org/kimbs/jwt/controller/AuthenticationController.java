package org.kimbs.jwt.controller;

import lombok.RequiredArgsConstructor;
import org.kimbs.jwt.config.JwtTokenProvider;
import org.kimbs.jwt.model.AuthenticationBody;
import org.kimbs.jwt.model.User;
import org.kimbs.jwt.service.CustomUserDetailsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationBody data) {
        try {
            String username = data.getEmail();
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.customUserDetailsService.findUserByEmail(username).getRoles());

            HttpHeaders headers = new HttpHeaders();
            headers.set("token", token);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            model.put("auth", auth);

            return new ResponseEntity<>(model, headers, HttpStatus.OK);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User userExists = customUserDetailsService.findUserByEmail(user.getEmail());

        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
        }

        User created = customUserDetailsService.saveUser(user);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
