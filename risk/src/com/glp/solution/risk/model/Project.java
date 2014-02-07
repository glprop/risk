package com.glp.solution.risk.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Project {

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



	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NoModify 
	@ManyToMany
	
	@ListProperties("name")
	 private Collection<Customer> customers;

	public Collection<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Collection<Customer> customers) {
		this.customers = customers;
	}
	
	 @ManyToMany
	 @ListProperties("name")
	 @NoModify 
	 private Collection<Variable> variables;

	public Collection<Variable> getVariables() {
		return variables;
	}

	public void setVariables(Collection<Variable> variables) {
		this.variables = variables;
	}	
	 @ManyToMany
	 @ListProperties("name")
	 @NoModify 
	 private Collection<Score> scores;

	public Collection<Score> getScores() {
		return scores;
	}

	public void setScores(Collection<Score> scores) {
		this.scores = scores;
	}		
	
	
	@NoModify
	@ManyToOne
	@DescriptionsList
	private Score finalScore;

	public Score getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(Score finalScore) {
		this.finalScore = finalScore;
	}


}

