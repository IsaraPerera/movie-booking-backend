package com.example.moviebookingbackend.dto.secure.impl;

import com.example.moviebookingbackend.config.JWTUtil;
import com.example.moviebookingbackend.dao.UserDAO;
import com.example.moviebookingbackend.dto.UserDTO;
import com.example.moviebookingbackend.dto.secure.JWTResponseDTO;
import com.example.moviebookingbackend.dto.secure.SignInDTO;
import com.example.moviebookingbackend.entity.UserEntity;
import com.example.moviebookingbackend.service.secure.AuthService;
import com.example.moviebookingbackend.util.Conversion;
import com.example.moviebookingbackend.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final Conversion conversion;
    private final UserDAO userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;


    @Override
    public JWTResponseDTO signIn(SignInDTO signIn) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        signIn.getEmail(),
                        signIn.getPassword()
                ));

        var authUser= userDao.findByEmail(signIn.getEmail())
                .orElseThrow(()->
                        new UsernameNotFoundException("User not found"));

        String token = jwtUtil.generateToken(
                authUser.getEmail(),
                authUser.getAuthorities());

        return JWTResponseDTO
                .builder()
                .token(token)
                .build();

    }

    @Override
    public JWTResponseDTO signUp(UserDTO user) {
        if(userDao.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("User already exists");
        }
        user.setUserId(IDGenerate.userId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity savedUser =
                userDao.save(conversion.toUserEntity(user));

        String token = jwtUtil.generateToken(
                savedUser.getEmail(),
                savedUser.getAuthorities()
        );
        return JWTResponseDTO
                .builder()
                .token(token)
                .build();
    }
}