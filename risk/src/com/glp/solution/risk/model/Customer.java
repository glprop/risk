package com.glp.solution.risk.model;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.glp.solution.risk.web.action.*;

@Entity

public class Customer {

	@Id
	@Hidden
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "VARCHAR(400)")
	@Required
	private String name;

	@Column
	
	private Integer emma;

	@ManyToOne
	@OrderBy("value desc")
	@DescriptionsList(order="value desc")
	private BankRating dbRating;

	// composite credit appraisal
	@ManyToOne
	@OrderBy("value desc")
	@DescriptionsList(order="value desc")
	
	
	private CompositeCreditAppraisal compositeCreditAppraisal;



	// Registered Capita
	@Column
	private Long registeredCapital;
	
	@ManyToOne
	@OrderBy("value desc")
	@DescriptionsList(order="value desc",descriptionProperties="name")
	
	
	private CustomerEvaluation customerEvaluation;

	// Vendor support
	@ManyToOne
	@OrderBy("value desc")
	@DescriptionsList(order="value desc",descriptionProperties="name")
	
	
	private VendorSupport vendorSupport;
	
	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@OrderBy("value desc")
	@DescriptionsList(order="value desc",descriptionProperties="name")
	
	private UtilizedLocation utilizedLocation;
	
	//@Column
	//@OnChange(OnChangeCustomerDataAction.class)
	//private BigDecimal leverageRatio;

	@Column
	@Hidden
	private Date  lastModifyDate;	
	
	public Date  getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	@Transient
	@ReadOnly
	//private Date  modifyDate;
	public Date  getModifyDate() {
		return lastModifyDate;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int customerId) {
		this.id = customerId;
	}	

	public VendorSupport getVendorSupport() {
		return vendorSupport;
	}

	public void setVendorSupport(VendorSupport vendorSupport) {
		this.vendorSupport = vendorSupport;
	}

	public BankRating getDbRating() {
		return dbRating;
	}

	public void setDbRating(BankRating dBRating) {
		dbRating = dBRating;
	}

	public Long getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(Long registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	// composite credit appraisal

	public CompositeCreditAppraisal getCompositeCreditAppraisal() {
		return compositeCreditAppraisal;
	}

	public void setCompositeCreditAppraisal(
			CompositeCreditAppraisal compositeCreditAppraisal) {
		this.compositeCreditAppraisal = compositeCreditAppraisal;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmma() {
		return emma;
	}

	public void setEmma(Integer EMMA) {
		this.emma = EMMA;
	}

/*	
	@EditOnly
	public Collection<ScoreBak> getSubScore() {
		 Query query = XPersistence.getManager().createQuery("from Score c where type='CustomerData' and name not like 'final%' order by c.orderNum");
		 Collection<ScoreBak> list =  query.getResultList();
		 Map<String,Object> varsMap = ScoreCalculator.getVarsFromObject(this);
		 
		 for(ScoreBak riskScore:list){
			 if( riskScore.getRiskFunction()!= null
				&&  StringUtils.isNotBlank(riskScore.getRiskFunction().getValue())
					 ){
				 Object value = ScoreCalculator.calScore(varsMap, riskScore.getRiskFunction().getValue());
				 varsMap.put(riskScore.getName(), value);
				 riskScore.setScoreValue(value.toString());
			 }else{
				 riskScore.setScoreValue("no function");
			 }
		 }
		 return list;
	}


	public String getScore() {
		 Query query = XPersistence.getManager().createQuery("from Score c where type='CustomerData' and name like 'final%' order by c.orderNum");
		 Collection<ScoreBak> list =  query.getResultList();
		 if(list.isEmpty()){
			 return "no finalScore function defined";
		 }
		 ScoreBak riskScore = list.iterator().next();
		 if( riskScore.getRiskFunction()!= null
			&&  StringUtils.isNotBlank(riskScore.getRiskFunction().getValue())
				 ){
			 Map<String,Object> varsMap = ScoreCalculator.getVarsFromObject(this);
			 return ScoreCalculator.calScore(varsMap,getSubScore(), riskScore.getRiskFunction().getValue()).toString();
		 }else{
			 return "no finalScore function defined";
		 }
	}
*/
	public CustomerEvaluation getCustomerEvaluation() {
		return customerEvaluation;
	}

	public void setCustomerEvaluation(CustomerEvaluation customerEvaluation) {
		this.customerEvaluation = customerEvaluation;
	}

	public UtilizedLocation getUtilizedLocation() {
		return utilizedLocation;
	}

	public void setUtilizedLocation(UtilizedLocation utilizedLocation) {
		this.utilizedLocation = utilizedLocation;
	}
	
	@PreUpdate
	public void onSave(){
		setLastModifyDate(new Date());
	}
	
}
