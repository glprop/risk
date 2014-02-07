package com.glp.solution.risk.web.action;

import org.openxava.actions.*;
import org.openxava.view.*;

import com.glp.solution.risk.model.*;
 
/**
 * @author Javier Paniza
 */
public class OnChangeScoreType extends OnChangePropertyBaseAction { // 1
 
 public void execute() throws Exception {
	 String value = (String) getNewValue(); // 2
	 //if (value == null) return;
	 //if (value.startsWith("Javi")) 
	 if("RangeScore".equalsIgnoreCase(value)){
		   	getView().setHidden("ranges", false);
	    	getView().setHidden("varOrScoreName", false);
	    	getView().setHidden("riskFunction", true);
		 
	 }else if("FunctionScore".equalsIgnoreCase(value)){
		   	getView().setHidden("ranges", true);
	    	getView().setHidden("varOrScoreName", true);
	    	getView().setHidden("riskFunction", false);
	 }else{
		   	getView().setHidden("ranges", true);
	    	getView().setHidden("varOrScoreName", true);
	    	getView().setHidden("riskFunction", true);
		 
	 }

 }
 
}