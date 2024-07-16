package com.example.books.dto;

import com.example.books.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
