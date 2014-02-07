package com.glp.solution.risk.validator;

import java.math.*;

import org.openxava.util.*;
import org.openxava.validators.*;

public class BigDecimalRequiredValidator implements IPropertyValidator{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1202977662222509315L;

	public void validate(Messages errors, Object value, String propertyName,
			String modelName) throws Exception {
		if(value == null){
			errors.add("required",propertyName,modelName);
			return;
		}
		if(!(value instanceof BigDecimal)){
			errors.add("expected_type",propertyName,modelName,"bigdecimal");
		}
		
	}

}
