package com.springboot.service;

import java.util.List;

import com.springboot.model.Relations;

public interface RelationsService 
{
	public List<Relations> findAllPeopleKnower();
	public void addPeopleKnowerUser(Relations p);
}
