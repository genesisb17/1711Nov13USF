package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Data;
import com.springboot.repository.DataRepository;

@Service
@Transactional
public class DataServiceImpl implements DataService
{

	@Autowired
	private DataRepository dRepo;

	public void addData(Data d) 
	{
		// TODO Auto-generated method stub
		dRepo.save(d);
	}

	public List<Data> findAllData() 
	{
		// TODO Auto-generated method stub
		return dRepo.findAll();
	}

}
