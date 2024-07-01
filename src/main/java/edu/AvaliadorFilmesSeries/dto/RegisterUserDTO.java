package edu.AvaliadorFilmesSeries.dto;

import edu.AvaliadorFilmesSeries.model.UserRole;

public record RegisterUserDTO(String username, String password, String name, String bio, UserRole role) {
}
