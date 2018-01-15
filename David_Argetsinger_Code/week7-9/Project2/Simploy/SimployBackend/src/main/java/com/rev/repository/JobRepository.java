package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.domain.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}
