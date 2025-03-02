package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BorrowRequests;
import com.example.demo.service.BorrowRequestsService;

@RestController
@RequestMapping("/borrow-requests")
public class BorrowRequestsContoller {
	@Autowired
    private BorrowRequestsService borrowRequestService;

    @PostMapping("/request/{studentId}/{bookId}")
    public BorrowRequests requestBook(@PathVariable int studentId, @PathVariable int bookId) {
        return borrowRequestService.requestBook(studentId, bookId);
    }

    @GetMapping("/all")
    public List<BorrowRequests> getAllRequests() {
        return borrowRequestService.getAllRequests();
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<BorrowRequests> approveRequest(@PathVariable int id) {
        return ResponseEntity.ok(borrowRequestService.approveRequest(id));
    }
}
