package com.example.inventorymanagementbackend.repository;

import com.example.inventorymanagementbackend.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {

}
