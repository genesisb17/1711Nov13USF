package com.ex.orm;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BEARS")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="BEAR_ID")),
	@AttributeOverride(name="name", column=@Column(name="BEAR_NAME")),
	@AttributeOverride(name="cave", column=@Column(name="BEAR_CAVE"))
})
public class Bear extends Animal implements Serializable {

	private static final long serialVersionUID = -6062750562012564188L;
	
	// The int id and String name fields are inherited from Animal
//	@Id
//	@Column(name="BEAR_ID")
//	@SequenceGenerator(name="B_ID_SEQ", sequenceName="B_ID_SEQ")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="B_ID_SEQ")
//	private int id;
	
//	@Column(name="BEAR_NAME", nullable=false)
//	private String name;
	
	@Column(name="BEAR_COLOR")
	private String color;
	
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bear(String color) {
		super();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Bear [color=" + color + "]";
	}

}
