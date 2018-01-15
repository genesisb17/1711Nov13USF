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
import com.rev.domain.Skill;
import com.rev.domain.User;
import com.rev.service.ResumeService;
import com.rev.service.UserService;

@CrossOrigin()
@RestController
@RequestMapping(value = "/Resume")
public class ResumeController {
	
	@Autowired
	ResumeService service;
	

	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)

	public List<Resume> findAll() {
		return service.findAllResumes();
	}
	
	@CrossOrigin()
	@RequestMapping(method=RequestMethod.POST)
	public Resume addFC(@RequestBody Resume r){
		List<Skill> here=new ArrayList<>(); 
        r.setSkills(here);
		return service.addResume(r);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/update", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resume resumeUpdate(@RequestBody Resume r){
		Resume e=service.findResumeByResId(r.getResId());
		e.setDescription(r.getDescription());
		return service.addResume(e);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/id", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resume findById(@RequestBody Resume r){
		System.out.println("IN FINDBYID");
		return service.findResumeByResId(r.getResId());
	}
	
	@CrossOrigin()
	public Resume findById2(Integer r) {
		System.out.println("IN FINDBYID2");
		return service.findResumeByResId(r);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/uid", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resume findByUId(@RequestBody User u){
		ArrayList<Resume> here=new ArrayList<>(); 
		here=(ArrayList<Resume>) service.findAllResumes();
		for(Resume r: here) {
			if(r.getUser().getId()==u.getId())
				return r;
		}
		return null;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/addskill", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resume addSkill(@RequestBody Resume r){
		Resume x=service.findResumeByResId(r.getResId());
		List<Skill> here=new ArrayList<>(); 
		here=x.getSkills();
		here.add(r.getSkills().get(0));
		x.setSkills(here);
		return service.addResume(x);
	}
	
	@CrossOrigin()
	@RequestMapping(value="/deleteskill", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Resume deleteSkill(@RequestBody Resume r){
		Resume x=service.findResumeByResId(r.getResId());
		List<Skill> here=new ArrayList<>(); 
		here=x.getSkills();
		for(int i=0; i<here.size();i++) {
			if(here.get(i).getSkillId()==r.getSkills().get(0).getSkillId())
				here.remove(i);
		}
		x.setSkills(here);
		return service.addResume(x);
	}

}
