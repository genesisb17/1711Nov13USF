package com.springboot.service;

import java.util.List;

import com.springboot.model.Data;

public interface DataService 
{
	public void addData(Data d);
	public List<Data> findAllData();
}