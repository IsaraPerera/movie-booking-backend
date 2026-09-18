package com.example.moviebookingbackend.service.secure;




import com.example.moviebookingbackend.dto.UserDTO;
import com.example.moviebookingbackend.dto.secure.JWTResponseDTO;
import com.example.moviebookingbackend.dto.secure.SignInDTO;



public interface AuthService {
    JWTResponseDTO signIn(SignInDTO signIn);
    JWTResponseDTO signUp(UserDTO user);
}