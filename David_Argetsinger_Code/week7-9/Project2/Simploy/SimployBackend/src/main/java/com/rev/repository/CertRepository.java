package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.domain.Certification;

@Repository
public interface CertRepository extends JpaRepository<Certification, Integer> {

}
