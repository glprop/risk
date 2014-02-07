package com.glp.solution.risk.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Variable{

	 @Id @Hidden
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(columnDefinition="VARCHAR(4000)",length=500)
	 private String name;
	 
	 
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(columnDefinition="VARCHAR(4000)")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}

