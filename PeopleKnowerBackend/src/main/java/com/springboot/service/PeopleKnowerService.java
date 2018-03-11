package com.springboot.service;

import java.util.List;

import com.springboot.model.PeopleKnower;

public interface PeopleKnowerService {
	public void addPeopleKnowerUser(PeopleKnower p);
	public List<PeopleKnower> findAllPeopleKnower();
}
