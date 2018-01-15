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

import com.rev.domain.Project;
import com.rev.domain.Resume;
import com.rev.domain.User;
import com.rev.service.ProjectService;
import com.rev.service.ResumeService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/Project")
public class ProController {

	@Autowired
	ProjectService service;
	ResumeService resService;
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST)
	public Project addFC(@RequestBody Project p){
		System.out.println(p.toString());
		return service.addProject(p);
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Project> findAll() {
		return service.findAllProjects();
	}
	
	@CrossOrigin()
	@RequestMapping(value="/id")
	public @ResponseBody Project findById(@RequestBody Project p){
		return service.findOne(p.getproId());
	}
	
	@CrossOrigin()
	@RequestMapping(value="/delete", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Project delete(@RequestBody Project p){
		Project j=service.findOne(p.getproId());
		if(j==null)
			return null;
		if(j!=null) {
			service.delete(p.getproId());
		}
		return j;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/resid", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Project> findByResId(@RequestBody Resume r){
		ArrayList<Project> here=new ArrayList<>();  
		ArrayList<Project> test=new ArrayList<>();
		here=(ArrayList<Project>) service.findAllProjects();
		for(Project p: here) {
			if(p.getResume().getResId()==r.getResId())
				test.add(p);
		}
		return test;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/title")
	public @ResponseBody Project findByTitle(@RequestBody String title){
		return service.findProjectByTitle(title);
	}
}
