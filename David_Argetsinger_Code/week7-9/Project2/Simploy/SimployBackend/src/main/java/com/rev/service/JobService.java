package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.domain.Job;
import com.rev.domain.Project;
import com.rev.repository.JobRepository;

@Service
@Transactional
public class JobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	public Job addJob(Job j) {
		return jobRepo.save(j);
	}
	
	public List<Job> findAllJobs() {
		return jobRepo.findAll();
	}
	
	public Job findOne(Integer id) {
		return jobRepo.findOne(id);
	}
	
	public void delete(Integer id) {
		jobRepo.delete(id);
	}

}
