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

import com.rev.domain.Job;
import com.rev.domain.Project;
import com.rev.domain.Resume;
import com.rev.domain.Skill;
import com.rev.domain.User;
import com.rev.service.JobService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/Job")
public class JobController {
	
	@Autowired
	JobService service;
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST)
	public Job addFC(@RequestBody Job j){
		return service.addJob(j);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Job> findAll() {
		return service.findAllJobs();
	}
	
	@CrossOrigin()
	@RequestMapping(value="/id", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Job findById(@RequestBody Job j){
		Integer id = j.getjobId();
		return service.findOne(id);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/delete", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Job delete(@RequestBody Job x){
		Job j=service.findOne(x.getjobId());
		if(j==null)
			return null;
		if(j!=null) {
			service.delete(x.getjobId());
		}
		return j;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/addskill", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Job addSkill(@RequestBody Job j){
		Job x=service.findOne(j.getjobId());
		List<Skill> here=new ArrayList<>();
		here=x.getSkills();
		here.add(j.getSkills().get(0));
		x.setSkills(here);
		return service.addJob(x);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/uid", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Job findByUId(@RequestBody User u){
		ArrayList<Job> here=new ArrayList<>(); 
		here=(ArrayList<Job>) service.findAllJobs();
		for(Job r: here) {
			if(r.getUser().getId()==u.getId())
				return r;
		}
		return null;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/uidjobs", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Job> findJobsByUId(@RequestBody User u){
		ArrayList<Job> here=new ArrayList<>(); 
		ArrayList<Job> test=new ArrayList<>();
		here=(ArrayList<Job>) service.findAllJobs();
		for(Job r: here) {
			if(r.getUser().getId()==u.getId())
				test.add(r);
		}
		return test;
	}

}
