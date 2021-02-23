package com.example.inventorymanagementbackend.controller;

import java.util.List;
// import java.util.Map;

import com.example.inventorymanagementbackend.exception.ResourceNotFoundException;
import com.example.inventorymanagementbackend.model.Painting;
import com.example.inventorymanagementbackend.repository.PaintingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PaintingController {

    @Autowired
    private PaintingRepository paintingRepository;

    @PostMapping("/add/single-painting")
    public Painting addPainting(@RequestBody Painting p) {
        return paintingRepository.save(p);
    }

    @GetMapping("/paintings")
    public ResponseEntity<List<Painting>> getAllPaintings() {
        try {
            List<Painting> paintings = paintingRepository.findAll();

            if (paintings.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(paintings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/painting/{id}")
    public ResponseEntity<Painting> getPaintingById(@PathVariable Long id) {
        Painting p = paintingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Painting does not exist."));

        return ResponseEntity.ok(p);
    }

    @PutMapping("/update-painting/{id}")
    public ResponseEntity<Painting> editPainting(@PathVariable Long id, @RequestBody Painting newPaintingDetails) {
        Painting p = paintingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Painting does not exist."));

        p.setName(newPaintingDetails.getName());
        p.setType(newPaintingDetails.getType()); 
        p.setMedium(newPaintingDetails.getMedium());
        p.setDimensions(newPaintingDetails.getDimensions());
        p.setImgPath(newPaintingDetails.getImgPath());
        p.setPrice(newPaintingDetails.getPrice());

        Painting updatedPainting = paintingRepository.save(p);
        return ResponseEntity.ok(updatedPainting);
    }

    // @DeleteMapping("")
    // public Map<String, Boolean> deletePainting(Long id) {

    // }

}
