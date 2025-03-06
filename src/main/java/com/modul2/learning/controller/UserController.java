package com.modul2.learning.controller;

import com.modul2.learning.dto.UserDTO;
import com.modul2.learning.dto.validation.AdvancedInfo;
import com.modul2.learning.dto.validation.ValidationOrder;
import com.modul2.learning.entities.User;
import com.modul2.learning.mapper.UserMapper;
import com.modul2.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//operatii de tipul CRUD - CREATE, READ, UPDATE, DELETE
@RestController
//folosim forma de plural la endpoints
@RequestMapping("/users")
public class UserController {
    //dependency injection + inversion of control
    //bean - un object manage-uit de SpringBoot
    @Autowired
    private UserService userService;

    //cand cream date, folosim POST
    //nu mai este nevoie de "/create", pentru ca un POST reprezinta automat crearea unei noi entitati (ca principiu)
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody User user) {
        //comment daca am avea parametrul ca DTO:
        //pas1: il convertesc intr-o entitate User (printr-o clasa Mapper)
        //pas 2: linia de mai jos
        User createdUser = userService.create(user);
        //pas 3: convertesc entitatea din nou intr-un DTO
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/with-apps")
    public ResponseEntity<?> createWithApplications(@Validated(ValidationOrder.class) @RequestBody UserDTO userDTO) {
        User userToCreate = UserMapper.userDTO2User(userDTO);
        User createdUser = userService.create(userToCreate);
        return ResponseEntity.ok(UserMapper.user2UserDTO(createdUser));
    }

    //returnam un user dupa id
    //id-ul il pun in path/cale, pentru ca un GET nu are request body (doar response body)
    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable(name = "userId") Long userIdToSearchFor) {
        User foundUser = userService.getById(userIdToSearchFor);
        return ResponseEntity.ok(foundUser);
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }



}
