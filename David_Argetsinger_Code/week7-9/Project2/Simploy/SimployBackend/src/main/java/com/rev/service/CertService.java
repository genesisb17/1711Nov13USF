package com.rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.domain.Certification;
import com.rev.domain.Project;
import com.rev.repository.CertRepository;

@Service
@Transactional
public class CertService {
	
	@Autowired
	private CertRepository certRepo;
	
	public Certification addCert(Certification c) {
		return certRepo.save(c);
	}
	
	public List<Certification> findAllCertifications() {
		return certRepo.findAll();
	}
	
	public Certification findOne(Integer id) {
		return certRepo.findOne(id);
	}
	
	public void delete(Integer id) {
		certRepo.delete(id);
	}

}
