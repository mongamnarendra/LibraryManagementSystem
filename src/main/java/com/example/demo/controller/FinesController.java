package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Fines;
import com.example.demo.service.FinesService;

@RestController
@RequestMapping("/fines")
public class FinesController {
	@Autowired
    private FinesService fineService;

    @PostMapping("/issue/{borrowedBookId}")
    public ResponseEntity<Fines> issueFine(@PathVariable int borrowedBookId) {
        return ResponseEntity.ok(fineService.issueFine(borrowedBookId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fines>> getAllFines() {
        return ResponseEntity.ok(fineService.getAllFines());
    }
}
