package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.domain.Project;
import com.rev.domain.Resume;
import com.rev.repository.ProRepository;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	private ProRepository proRepo;
	
	public Project addProject(Project p) {
		return proRepo.save(p);
	}
	
	public List<Project> findAllProjects() {
		return proRepo.findAll();
	}

	public Project findOne(Integer id) {
		return proRepo.findOne(id);
	}
	
	public void delete(Integer id) {
		proRepo.delete(id);
	}
	
	/*public <List>Project findProjectByResid(Integer i) {
		return proRepo.findProjectByResid(i);
	}*/
	
	public Project findProjectByTitle(String title) {
		return proRepo.findProjectByTitle(title);
	}

}
