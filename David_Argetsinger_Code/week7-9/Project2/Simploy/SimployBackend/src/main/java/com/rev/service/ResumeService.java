package com.rev.service;

import java.util.List;

import com.rev.domain.Resume;
import com.rev.domain.User;

public interface ResumeService {
	public Resume addResume(Resume r);
	public List<Resume> findAllResumes();
	public Resume findResumeByResId(Integer id);

}
