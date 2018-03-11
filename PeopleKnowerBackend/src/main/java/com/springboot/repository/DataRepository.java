package com.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Data;
@Repository
public interface DataRepository extends JpaRepository<Data, Integer>
{
	//public Data findPeopleBydata_id(Integer id);
}