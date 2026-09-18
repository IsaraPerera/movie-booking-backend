package com.example.moviebookingbackend.controller.secure;


import com.example.moviebookingbackend.dto.UserDTO;
import com.example.moviebookingbackend.dto.secure.JWTResponseDTO;
import com.example.moviebookingbackend.dto.secure.SignInDTO;
import com.example.moviebookingbackend.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<JWTResponseDTO> signUp(@RequestBody UserDTO signInUser) {
        return ResponseEntity.ok(authService.signUp(signInUser));
    }

    @PostMapping("/signin")
    public ResponseEntity<JWTResponseDTO> signIn(@RequestBody SignInDTO signUpUser){
        return ResponseEntity.ok(authService.signIn(signUpUser));
    }
}
