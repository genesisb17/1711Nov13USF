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

import com.rev.domain.Education;
import com.rev.domain.Project;
import com.rev.domain.Resume;
import com.rev.service.EduService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/Education")
public class EduController {
	
	@Autowired
	EduService service;
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST)
	public Education addFC(@RequestBody Education e){
		return service.addEdu(e);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Education> findAll() {
		return service.findAllEducations();
	}
	
	@CrossOrigin()
	@RequestMapping(value="/id", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Education findById(@RequestBody Education e){
		Integer id = e.getEdu_id();
		return service.findOne(id);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/delete", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Education delete(@RequestBody Education e){
		Education j=service.findOne(e.getEdu_id());
		if(j==null)
			return null;
		if(j!=null) {
			service.delete(e.getEdu_id());
		}
		return j;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/resid", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Education> findByResId(@RequestBody Resume r){
		ArrayList<Education> here=new ArrayList<>();  
		ArrayList<Education> test=new ArrayList<>();
		here=(ArrayList<Education>) service.findAllEducations();
		for(Education e: here) {
			if(e.getResume().getResId()==r.getResId())
				test.add(e);
		}
		return test;
	}

}
