package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

     ResponseEntity<String> addUser(UserDTO userDTO);
}
