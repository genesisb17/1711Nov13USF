package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.domain.Experience;
import com.rev.domain.Project;
import com.rev.repository.ExpRepository;

@Service
@Transactional
public class ExpService {
	
	@Autowired
	private ExpRepository expRepo;
	
	public Experience addExp(Experience e) {
		return expRepo.save(e);
	}
	
	public List<Experience> findAllExperiences() {
		return expRepo.findAll();
	}
	
	public Experience findOne(Integer id) {
		return expRepo.findOne(id);
	}
	
	public void delete(Integer id) {
		expRepo.delete(id);
	}

}
