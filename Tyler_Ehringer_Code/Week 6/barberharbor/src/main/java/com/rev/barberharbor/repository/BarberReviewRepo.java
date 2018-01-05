package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.BarberReview;

@Repository
public interface BarberReviewRepo extends JpaRepository<BarberReview, Long>{

}
