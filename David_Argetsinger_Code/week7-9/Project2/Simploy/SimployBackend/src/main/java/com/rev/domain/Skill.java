package com.rev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "SKILL")
public class Skill {

	@Id
	@Column(name = "skillId")
	@SequenceGenerator(allocationSize = 1, name = "skillSeq", sequenceName = "SKILL_SEQ")
	@GeneratedValue(generator = "skillSeq", strategy = GenerationType.SEQUENCE)
	private Integer skillId;

	@Column(name = "title")
	private String title;

	public Skill() {
		super();
	}

	public Skill(String title) {
		super();
		this.title = title;
	}

	public Skill(Integer skillId, String title) {
		super();
		this.skillId = skillId;
		this.title = title;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", title=" + title + "]";
	}

	

}
