package com.glp.solution.risk.model;

import java.math.*;

import javax.persistence.*;

import org.hibernate.validator.*;
import org.openxava.annotations.*;

import com.glp.solution.risk.validator.*;

@Entity
public class RangeValue{
	
	
	 @Id @Hidden
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column
	 //@Required
	 private BigDecimal top;

	 @Column
	 //@Required
	 private BigDecimal floor;

	 @Column
	 @PropertyValidator(BigDecimalRequiredValidator.class)
	 private BigDecimal score;
	 
	 @ManyToOne
	 @DescriptionsList
	 @Required
	 private Score rangeScore;

	 public Score getRangeScore() {
	     return rangeScore;
	 }

	 public void setRangeScore(Score rangeScore) {
	     this.rangeScore = rangeScore;
	 }	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTop() {
		return top;
	}

	public void setTop(BigDecimal top) {
		this.top = top;
	}

	public BigDecimal getFloor() {
		return floor;
	}

	public void setFloor(BigDecimal floor) {
		this.floor = floor;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}
	 
	 @Column(columnDefinition="VARCHAR(200)",length=200)
	 //@Required
	 private String name;

	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
