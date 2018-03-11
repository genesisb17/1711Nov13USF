package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.PeopleKnower;


@Repository

public interface PeopleKnowerRepository extends JpaRepository<PeopleKnower, String> {
	public PeopleKnower findPeopleByUsername(String User);

}
