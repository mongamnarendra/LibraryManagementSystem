package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.service.BooksService;

@RestController
@RequestMapping("/book")
public class BooksController {

	@Autowired
    private BooksService bookService;

    @PostMapping("/add")
    public Books addBook(@RequestBody Books book) {
        return bookService.addBook(book);
    }

    @GetMapping("/all")
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable int id) {
       return bookService.getBookById(id).orElse(null);
    }
}
