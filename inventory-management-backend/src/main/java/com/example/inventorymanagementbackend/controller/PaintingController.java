package com.example.inventorymanagementbackend.controller;

import java.util.List;

import com.example.inventorymanagementbackend.model.Painting;
import com.example.inventorymanagementbackend.repository.PaintingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PaintingController {

    @Autowired
    private PaintingRepository paintingRepository;

    @GetMapping("/paintings")
    public ResponseEntity<List<Painting>> getAllPaintings() {
        try {
            List<Painting> paintings = paintingRepository.findAll();
            
            if(paintings.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(paintings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
