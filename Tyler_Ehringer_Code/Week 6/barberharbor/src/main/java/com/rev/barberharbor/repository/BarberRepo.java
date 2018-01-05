package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Barber;

@Repository
public interface BarberRepo extends JpaRepository<Barber, Long>{

}
