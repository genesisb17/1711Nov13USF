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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "RESUME")
public class Resume {

	@Id
	@Column(name = "resid")
	@SequenceGenerator(allocationSize = 1, name = "resumeSeq", sequenceName = "RESUME_SEQ")
	@GeneratedValue(generator = "resumeSeq", strategy = GenerationType.SEQUENCE)
	private Integer resid;

	@Column(name = "description")
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "resume_skills", joinColumns = { @JoinColumn(name = "resid") }, inverseJoinColumns = {
			@JoinColumn(name = "skillId") })
	private List<Skill> skills = new ArrayList<>();

	public Resume() {
		super();
	}

	public Resume(Integer resid, String description, User user, List<Skill> skills) {
		super();
		this.resid = resid;
		this.description = description;
		this.user = user;
		this.skills = skills;
	}

	public Resume(String description, User user, List<Skill> skills) {
		super();
		this.description = description;
		this.user = user;
		this.skills = skills;
	}

	public Integer getResId() {
		return resid;
	}

	public void setResId(Integer resid) {
		this.resid = resid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Resume [resid=" + resid + ", description=" + description + ", user=" + user + ", skills=" + skills
				+ "]";
	}

}
