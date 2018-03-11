package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.PeopleKnower;
import com.springboot.model.Relations;

@Repository
public interface RelationsRepository  extends JpaRepository<Relations, String> 
{

}
