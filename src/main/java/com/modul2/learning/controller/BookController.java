package com.modul2.learning.controller;

import com.modul2.learning.dto.BookDTO;
import com.modul2.learning.entities.Book;
import com.modul2.learning.entities.User;
import com.modul2.learning.mapper.BookMapper;
import com.modul2.learning.service.BookService;
import com.modul2.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @PostMapping("/{userId}")
    public ResponseEntity<?> create(@PathVariable Long userId, @RequestBody BookDTO bookDto) {
        Book bookToCreate = BookMapper.bookDto2Book(bookDto);
        Book createdBook = bookService.create(bookToCreate, userId);
        return ResponseEntity.ok(BookMapper.bookDto2Book(createdBook));
    }
}
