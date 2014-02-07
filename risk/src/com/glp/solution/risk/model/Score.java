package com.glp.solution.risk.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.glp.solution.risk.web.action.*;

@Entity
public class Score {

	 @Id @Hidden
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;


	 @Column(columnDefinition="VARCHAR(200)",length=200)
	 @Required
	 private String name;

	 @Required
	 
	 
	 @NoCreate()
	 @NoModify()
	 
	 @ManyToOne(optional=false,fetch=FetchType.LAZY)
	 @DescriptionsList(order="value", descriptionProperties="name")
	 //@DefaultValueCalculator(value=IntegerCalculator.class, properties=
	 //  @PropertyValue(name="RangeScore", value="1")
	 //)
	 @OnChange(OnChangeScoreType.class)
	 private ScoreType scoreType;

	 @Column(columnDefinition="VARCHAR(200)",length=200)
	 @Required
	 private String varOrScoreName;
	 
	@OneToMany(mappedBy="rangeScore")
	 @OrderBy("score desc")
	 private Collection<RangeValue> ranges;

	@Column(columnDefinition="VARCHAR(4000)",length=4000)
	private String riskFunction;	

	 public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 public ScoreType getScoreType() {
		return scoreType;
	}

	public void setScoreType(ScoreType scoreType) {
		this.scoreType = scoreType;
	}

	public String getVarOrScoreName() {
		return varOrScoreName;
	}

	public void setVarOrScoreName(String varOrScoreName) {
		this.varOrScoreName = varOrScoreName;
	}

	
	public Collection<RangeValue> getRanges() {
		return ranges;
	}

	public void setRanges(Collection<RangeValue> ranges) {
		this.ranges = ranges;
	}
	public String getRiskFunction() {
		return riskFunction;
	}

	public void setRiskFunction(String riskFunction) {
		this.riskFunction = riskFunction;
	}

}

