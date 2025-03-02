package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;
import com.example.demo.entity.BorrowRequests;
import com.example.demo.entity.Student;
import com.example.demo.repository.BooksRepo;
import com.example.demo.repository.BorrowRequestRepo;
import com.example.demo.repository.StudentRepo;

@Service
public class BorrowRequestsService {

	@Autowired
	private BorrowRequestRepo borrowRequestRepo;

	@Autowired
	private StudentRepo repo;

	@Autowired
	private BooksRepo booksRepo;

	public BorrowRequests requestBook(int student_id, int book_id) {
		Student student = repo.findById(student_id).orElse(null);
		Books book = booksRepo.findById(book_id).orElse(null);

		if (student != null && book != null) {
			BorrowRequests borrowRequests = new BorrowRequests();
			borrowRequests.setBook(book);
			borrowRequests.setStudent(student);
			return borrowRequestRepo.save(borrowRequests);
		}

		throw new RuntimeException("Student or Book not found!");

	}

	public List<BorrowRequests> getAllRequests() {
		return borrowRequestRepo.findAll();
	}
	
	
	public BorrowRequests approveRequest(int requestId) {
		Optional<BorrowRequests> requestOpt = borrowRequestRepo.findById(requestId);
        if (requestOpt.isPresent()) {
            BorrowRequests request = requestOpt.get();
            request.setStatus(BorrowRequests.Status.APPROVED);
            return borrowRequestRepo.save(request);
        }
        throw new RuntimeException("Request not found!");
	}

}
