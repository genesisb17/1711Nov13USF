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

import com.rev.domain.Experience;
import com.rev.domain.Project;
import com.rev.domain.Resume;
import com.rev.service.ExpService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/Experience")
public class ExpController {

	@Autowired
	ExpService service;
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST)
	public Experience addFC(@RequestBody Experience e){
		return service.addExp(e);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Experience> findAll() {
		return service.findAllExperiences();
	}
	
	@CrossOrigin()
	@RequestMapping(value="/id", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Experience findById(@RequestBody Experience e){
		Integer id = e.getexpId();
		return service.findOne(id);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/delete", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Experience delete(@RequestBody Experience e){
		Experience j=service.findOne(e.getexpId());
		if(j==null)
			return null;
		if(j!=null) {
			service.delete(e.getexpId());
		}
		return j;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/resid", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Experience> findByResId(@RequestBody Resume r){
		ArrayList<Experience> here=new ArrayList<>();  
		ArrayList<Experience> test=new ArrayList<>();
		here=(ArrayList<Experience>) service.findAllExperiences();
		for(Experience e: here) {
			if(e.getResume().getResId()==r.getResId())
				test.add(e);
		}
		return test;
	}
}
