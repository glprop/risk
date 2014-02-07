package com.glp.solution.risk.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class ScoreFunction {

	 @Id @Hidden
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 @Column(columnDefinition="VARCHAR(200)",length=200)
	 @Required
	 private String name;


	@Column(columnDefinition="VARCHAR(3000)",length=4000)
	@Required 
	private String value;

	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
