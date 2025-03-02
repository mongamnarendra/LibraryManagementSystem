package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BorrowRequests;
import com.example.demo.entity.BorrowedBook;
import com.example.demo.repository.BorrowRequestRepo;
import com.example.demo.repository.BorrowedBooksRepo;

@Service
public class BorrowedBookService {
	@Autowired
    private BorrowedBooksRepo borrowedBookRepository;

    @Autowired
    private BorrowRequestRepo borrowRequestRepository;

    public BorrowedBook borrowBook(int requestId) {
        BorrowRequests requestOpt=borrowRequestRepository.findById(requestId).orElse(null);

        if (requestOpt!=null && requestOpt.getStatus() == BorrowRequests.Status.APPROVED) {
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setStudent(requestOpt.getStudent());
            borrowedBook.setBook(requestOpt.getBook());
            borrowedBook.setIssuedDate(LocalDateTime.now());
            borrowedBook.setDueDate(LocalDateTime.now().plusDays(14)); // 2 weeks borrow time
            return borrowedBookRepository.save(borrowedBook);
        }
        throw new RuntimeException("Request not approved or not found!");
    }

    public List<BorrowedBook> getAllBorrowedBooks() {
        return borrowedBookRepository.findAll();
    }
}
