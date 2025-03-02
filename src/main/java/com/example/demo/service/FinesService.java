package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BorrowedBook;
import com.example.demo.entity.Fines;
import com.example.demo.repository.BorrowedBooksRepo;
import com.example.demo.repository.FinesRepo;

@Service
public class FinesService {
	@Autowired
	private FinesRepo fineRepository;

	@Autowired
	private BorrowedBooksRepo borrowedBookRepository;

	private static final double FINE_PER_DAY = 5.0; // 5 currency units per day

	public Fines issueFine(int borrowedBookId) {
		Optional<BorrowedBook> borrowedBookOpt = borrowedBookRepository.findById(borrowedBookId);

		if (borrowedBookOpt.isPresent()) {
			BorrowedBook borrowedBook = borrowedBookOpt.get();
			if (borrowedBook.getDueDate().isBefore(LocalDateTime.now())) {
				long daysLate = ChronoUnit.DAYS.between(borrowedBook.getDueDate(), LocalDateTime.now());
				double fineAmount = daysLate * FINE_PER_DAY;

				Fines fine = new Fines();
				fine.setStudent(borrowedBook.getStudent());
				fine.setBook(borrowedBook.getBook());
				fine.setAmount(fineAmount);
				return fineRepository.save(fine);
			}
		}
		return null;
	}

	public List<Fines> getAllFines() {
		return fineRepository.findAll();
	}
}
