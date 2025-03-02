package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BorrowedBook;
import com.example.demo.service.BorrowedBookService;

@RestController
@RequestMapping("/borrow")
public class BorrowBookController {
	@Autowired
	private BorrowedBookService borrowedBookService;

	@PostMapping("/borrow/{id}")
	public ResponseEntity<BorrowedBook> borrowBook(@PathVariable int id) {
		return ResponseEntity.ok(borrowedBookService.borrowBook(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<BorrowedBook>> getAllBorrowedBooks() {
		return ResponseEntity.ok(borrowedBookService.getAllBorrowedBooks());
	}
}
