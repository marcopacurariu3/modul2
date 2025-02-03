package com.modul2.learning.service;

import com.modul2.learning.entities.User;
import com.modul2.learning.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//clasa de business logic (un serviciu pe care aplicatia il ofera)
@Service
//@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public User create(User user) {
        if (user.getId() != null) {
            throw new RuntimeException("You cannot provide an ID to a new user that you want to create");
        }
        return userRepository.save(user);
    }

    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
