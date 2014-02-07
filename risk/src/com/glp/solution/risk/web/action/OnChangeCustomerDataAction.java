package com.glp.solution.risk.web.action;


import java.util.*;

import org.openxava.actions.*;
import org.openxava.view.*;

import com.glp.solution.risk.model.*;
 
/**
 * @author Javier Paniza
 */
public class OnChangeCustomerDataAction extends OnChangePropertyBaseAction { // 1
 
 public void execute() throws Exception {
 //String value = (String) getNewValue(); // 2
 //if (value == null) return;
 //if (value.startsWith("Javi")) 
 if( getView().getEntity() != null)
 {
    //;//
    //.setValue("type", Customer.Type.STEADY); // 3
    //getView().refreshCollections();
    Customer data = (Customer)getView().getEntity();
    //for(Score score :data.getSubScore())
    {
    	View subView = getView().getSubview("subScore");
    	//Map map = subView.getValues();
    	//subView.setMetaMembers(data.getSubScore());
    	//System.out.println(map);
    	//subView.setValue("score", score);
    	subView.refresh();
    			
    	//getView().setValue("subScore.1",score);
    }
   //getView().setValue("score", data.getScore());
    ;
	//getView().recalculateProperties();
   // getView().refreshCollections();
 }
 }
 
}