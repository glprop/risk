package com.glp.solution.risk.model;


import javax.persistence.*;

@Entity
public class UtilizedLocation implements ConstantIntegerValue<Integer>{

	 @Id 
	 @Column(columnDefinition="VARCHAR(200)",length=200)
	 private String name;

	@Column
	private Integer value;

	@Column(columnDefinition="VARCHAR(4000)", length=4000)
	private String description;
	 
	 
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}

