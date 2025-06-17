package com.example.dormitory_management.user_management;


import com.example.dormitory_management.user_management.jwt.JwtService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostConstruct
    private void PreRegisterUsers(){
        List<RegisterRequest> preRegistrations = new ArrayList<>();
        RegisterRequest request1 = new RegisterRequest("VanA", encoder.encode("123456"), "Nguyen Van A", "admin");
        RegisterRequest request2 = new RegisterRequest("VanB", encoder.encode("123456"), "Nguyen Van B", "manager");
        RegisterRequest request3 = new RegisterRequest("VanC", encoder.encode("123456"), "Nguyen Van C", "staff");
        preRegistrations.add(request1);
        preRegistrations.add(request2);
        preRegistrations.add(request3);

        for(RegisterRequest request : preRegistrations){
            if (!authService.verifyUserExists(request.getUsername())){
                authService.register(request);
            }
        }
    }
}
