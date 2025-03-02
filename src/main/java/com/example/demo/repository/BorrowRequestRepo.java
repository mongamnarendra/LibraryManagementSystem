package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BorrowRequests;

@Repository
public interface BorrowRequestRepo extends JpaRepository<BorrowRequests, Integer>{

}
