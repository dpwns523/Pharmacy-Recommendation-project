package com.example.pharmacyrecommendationproject.pharmacy.repository;

import com.example.pharmacyrecommendationproject.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {

}
