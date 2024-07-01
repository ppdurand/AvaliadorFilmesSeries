package edu.AvaliadorFilmesSeries.application.dto;

import edu.AvaliadorFilmesSeries.domain.model.UserRole;

public record RegisterUserDTO(String username, String password, String name, String bio, UserRole role) {
}
