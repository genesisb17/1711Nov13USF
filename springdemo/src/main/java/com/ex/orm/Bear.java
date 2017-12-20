package com.ex.orm;

import java.io.Serializable;

import javax.persistence.Id;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BEARS")
public class Bear implements Serializable
{
	private static final long serialVersionUID=-6062750562012564188L;
	@Id
	private int id;
	private String name;
	private String color;
}
