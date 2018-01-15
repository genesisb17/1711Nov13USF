package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.domain.Experience;

@Repository
public interface ExpRepository extends JpaRepository<Experience, Integer> {

}
