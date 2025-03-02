package com.example.demo.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRequests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "student_id" , nullable = false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "book_id" , nullable = false)
	private Books book;
	
	private LocalDateTime request_date=LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private Status status=Status.PENDING;
	
	public enum Status {
		PENDING,APPROVED, REJECTED
	}
	
	
}
