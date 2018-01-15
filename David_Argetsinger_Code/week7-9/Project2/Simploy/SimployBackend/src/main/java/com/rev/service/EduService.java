package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.domain.Education;
import com.rev.domain.Project;
import com.rev.repository.EduRepository;

@Service
@Transactional
public class EduService {
	
	@Autowired
	private EduRepository eduRepo;
	
	public Education addEdu(Education e) {
		return eduRepo.save(e);
	}
	
	public List<Education> findAllEducations() {
		return eduRepo.findAll();
	}
	
	public Education findOne(Integer id) {
		return eduRepo.findOne(id);
	}
	
	public void delete(Integer id) {
		eduRepo.delete(id);
	}

}
