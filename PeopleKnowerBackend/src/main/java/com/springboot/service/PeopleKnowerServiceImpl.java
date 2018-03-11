package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.PeopleKnower;
import com.springboot.repository.PeopleKnowerRepository;

@Service
@Transactional

public class PeopleKnowerServiceImpl implements PeopleKnowerService
{
	
	@Autowired
	private PeopleKnowerRepository pRepo;

	public void addPeopleKnowerUser(PeopleKnower p) 
	{
		// TODO Auto-generated method stub
		 pRepo.save(p);

	}

	public List<PeopleKnower> findAllPeopleKnower() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}
	
}
