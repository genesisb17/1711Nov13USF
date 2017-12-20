package com.ex.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ex.util.ConnectionUtil;


//@NamedQueries({ 
//	@NamedQuery(name = "findInstructorByIdHQL", query = "from Inscructor i where i.id = :id"),
//	@NamedQuery(name = "findInstructorByNameHQL", query = "from Inscructor i where name = :name") })

@Entity
@Table(name = "INSCRUTORS")
public class Instructor {
	@Id
	@Column(name = "INSCUCTOR_ID")
	@SequenceGenerator(name = "INSCUCTOR_ID_SEQ", sequenceName = "INSCUCTOR_ID_SEQ")
	@GeneratedValue(generator = "INSCUCTOR_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "INSCUCTOR_NAME", nullable = false, unique = true)
	private String name;


	// ({

	// })

	public Instructor() {
		super();
	}

	public Instructor(String name) {
		super();
		this.name = name;
	}

	public Instructor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + "]";
	}
	
//	public List<Instructor> inscructorByName(String like){
//		Session session = ConnectionUtil.getSession();
//		Query query = session.getNamedQuery("findInstructorByIdHQL").setString("name", like);
//		List<Instructor> i = query.list();
//		return i;
//	}

}
