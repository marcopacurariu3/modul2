package com.modul2.learning.repository;

import com.modul2.learning.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select user from user where user.firstName = :firstName")
    Optional<User> findByFirstNameAndLastNameOrderByFirstNameAsc(String firstName, String lastName);
}
