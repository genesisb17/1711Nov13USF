package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.domain.Education;

@Repository
public interface EduRepository extends JpaRepository<Education, Integer> {

}
