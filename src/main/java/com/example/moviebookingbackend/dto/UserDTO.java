package com.example.moviebookingbackend.dto;

import com.example.moviebookingbackend.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String Password;
}
