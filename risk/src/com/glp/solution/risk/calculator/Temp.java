package com.glp.solution.risk.calculator;

import java.math.*;

import javax.script.*;

public class Temp {
	
	
	public static void main(String[] args){
		String beanName = String.class.getSimpleName();//.getCanonicalName();
		System.out.println(beanName);
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		
		//String functionString = "emma<=1?10:emma==2?8:emma==3?6:emma==4?5:emma==5?4:emma==6?3.2:emma==7?2.4:emma==8?2:emma==9?1:0";
		String functionString = "registeredCapital>=450000000?10:registeredCapital>=85000000?9.25:registeredCapital>=8500000?8.5:registeredCapital>=6500000?7.75:registeredCapital>=4500000?7:registeredCapital>=2500000?6.25:registeredCapital>=1750000?5.5:registeredCapital>=1000000?4.75:registeredCapital>=650000?4:registeredCapital>=450000?3.25:registeredCapital>=300000?2.5:registeredCapital>=200000?1.75:1";
		BigDecimal value = new BigDecimal(400000000000l);
		engine.put("registeredCapital",value);
		try {
			Object ret = engine.eval(functionString);
			System.out.println(ret.getClass());
			System.out.println(ret);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
