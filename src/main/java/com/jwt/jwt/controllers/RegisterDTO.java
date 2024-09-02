package com.jwt.jwt.controllers;

import com.jwt.jwt.entities.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
