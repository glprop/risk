package com.glp.solution.risk.model;

import javax.persistence.*;

@Entity
public class ScoreType implements ConstantIntegerValue<Integer>{

	 @Id 
	 @Column(columnDefinition="VARCHAR(200)")
	 private String name;
	 
	 
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	 private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}



