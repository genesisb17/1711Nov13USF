package com.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.domain.Project;
import com.rev.domain.Resume;

@Repository
public interface ProRepository extends JpaRepository<Project, Integer> {

	public <List>Project findProjectByResume(Resume r);
	public Project findProjectByTitle(String title);
	//public <List>Project findProjectByResid(Integer i);
}
