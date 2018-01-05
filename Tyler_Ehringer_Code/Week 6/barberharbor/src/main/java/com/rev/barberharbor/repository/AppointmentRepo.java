package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

}
