package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> addUser(UserDTO userDTO) {
        if (nonNull(userDTO.getUserName()) && nonNull(userDTO.getPassword()) && nonNull(userDTO.getName())) {
            userRepository.
                    save(new User().setUserName(userDTO.getUserName())
                            .setName(userDTO.getName()).setPassword(userDTO.getPassword())
                            .setEmail(nonNull(userDTO.getEmail()) ? userDTO.getEmail() : ""));
            return ResponseEntity.status(HttpStatus.OK).body("User Details Added Successfully");
        }
        return ResponseEntity.badRequest().body("Either of required details are blank");
    }
}
