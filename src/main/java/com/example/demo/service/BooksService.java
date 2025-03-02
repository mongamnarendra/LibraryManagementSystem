package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;
import com.example.demo.repository.BooksRepo;

@Service
public class BooksService {
	@Autowired
    private BooksRepo bookRepository;

    public Books addBook(Books book) {
        return bookRepository.save(book);
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Books> getBookById(int id) {
        return bookRepository.findById(id);
    }
    
}
