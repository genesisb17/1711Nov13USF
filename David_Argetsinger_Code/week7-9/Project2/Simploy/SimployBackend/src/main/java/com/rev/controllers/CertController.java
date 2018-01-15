package com.rev.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.domain.Certification;
import com.rev.domain.Project;
import com.rev.domain.Resume;
import com.rev.domain.Skill;
import com.rev.service.CertService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/Certification")
public class CertController {
	
	@Autowired
	CertService service;
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST)
	public Certification addFC(@RequestBody Certification e){
		return service.addCert(e);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Certification> findAll() {
		return service.findAllCertifications();
	}
	
	@CrossOrigin()
	@RequestMapping(value="/id", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Certification findById(@RequestBody Certification c){
		Integer id = c.getCert_id();
		return service.findOne(id);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/delete", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Certification delete(@RequestBody Certification c){
		Certification j=service.findOne(c.getCert_id());
		if(j==null)
			return null;
		if(j!=null) {
			service.delete(c.getCert_id());
		}
		return j;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/resid", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Certification> findByResId(@RequestBody Resume r){
		ArrayList<Certification> here=new ArrayList<>();  
		ArrayList<Certification> test=new ArrayList<>();
		here=(ArrayList<Certification>) service.findAllCertifications();
		for(Certification c: here) {
			if(c.getResume().getResId()==r.getResId())
				test.add(c);
		}
		return test;
	}

}
