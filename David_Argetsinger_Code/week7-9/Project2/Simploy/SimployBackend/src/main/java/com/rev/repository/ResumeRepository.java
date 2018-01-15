package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.domain.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

}
