package com.glp.solution.risk.calculator;

import java.lang.reflect.*;
import java.math.*;
import java.util.*;

import javax.script.*;

import org.apache.commons.lang.*;
import org.directwebremoting.util.*;

import com.glp.solution.risk.model.*;

public class ScoreCalculator {

	private static final String GET = "get";
	static Logger log = Logger.getLogger(ScoreCalculator.class);
/*
	static public Object calScore(Map<String, Object> varsMap,Collection<ScoreBak> riskScoreList,String scoreFunction){
		 for(ScoreBak score:riskScoreList){
			 varsMap.put(score.getName(), convertToNum(score.getScoreValue()));
		 }
		return calScore(varsMap,scoreFunction);
	}
	static public Object calScore(Map<String, Object> varMap,
			String scoreFunction) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");

		//javascript is case sensitive, so we change everything to lower case during calculation.
		for (Map.Entry<String, Object> entry : varMap.entrySet()) {
			Object object = entry.getValue();
			object = convertToNum(object);
			engine.put(entry.getKey().toLowerCase(), object);

		}
		if (!StringUtils.isEmpty(scoreFunction)) {
			try {
				return engine.eval(scoreFunction.replaceAll(" ", "").toLowerCase());// "CCA*10+200");
			} catch (ScriptException e) {
				e.printStackTrace();
				return "cal error:" + e.getLocalizedMessage();
			}
		}
		return "no score function";

	}

	private static Object convertToNum(Object object) {
		if(object == null){
			return Integer.valueOf(0);
		}
		if(object instanceof String){				
			try {
				return Double
						.valueOf((String) object);
			} catch (NumberFormatException e) {
				return Integer.valueOf(0);//anything is numberic
			}				
		}
		return object;
	}

	static public Map<String, Object> getVarsFromObject(Object o) {
		Map<String, Object> map = new HashMap<String, Object>();
		Object[] args = new Object[0];
		try {
			Method[] methods = o.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().startsWith(GET) && !method.getName().equalsIgnoreCase(GET+"Score")) {
					Class<?> c = method.getReturnType();
					if (method.isVarArgs()) {
						continue;
					}
					boolean isWanted = false;
					if (c.equals(Long.class) || c.equals(Integer.class)
							|| c.equals(Short.class) 
							|| c.equals(String.class)
							|| c.equals(ConstantIntegerValue.class)
							|| c.equals(Float.class)
							|| c.equals(Double.class)
							|| c.equals(BigDecimal.class)

					) {
						isWanted = true;
					}
					if (!isWanted) {
						Class<?>[] interfaces = c.getInterfaces();
						for (Class<?> cz : interfaces) {
							if (cz.equals(ConstantIntegerValue.class)) {
								isWanted = true;
								break;
							}
						}
					}
					if (!isWanted) {
						continue;
					}
					Object value = method.invoke(o, args);
					String propName = method.getName().substring(GET.length());
					if(value == null){
						value = Integer.valueOf(0);
					}
					if (value instanceof Number) {
						map.put(propName, value);
					} else if (value instanceof String) {
						try {
							Double convertedValue = Double
									.valueOf((String) value);
							map.put(propName, convertedValue);
						} catch (NumberFormatException e) {
							map.put(propName, value);
						}
					} else if (value instanceof ConstantIntegerValue) {
						map.put(propName,
								((ConstantIntegerValue) value).getValue());
					}
				}
			}

		} catch (IllegalAccessException e) {
			log.warn("", e);
		} catch (InvocationTargetException e) {
			log.warn("", e);
		}
		return map;

	}
	/*
	 * static public String getScoreFunction(String beanName,String scoreName){
	 * Connection con = null; try { con =
	 * DataSourceConnectionProvider.getByComponent
	 * ("RiskFunction").getConnection(); // 1 //String table =
	 * MetaModel.get("RiskFunction").getMapping().getTable(); PreparedStatement
	 * ps =
	 * con.prepareStatement("select value from risk_function where name = '" +
	 * beanName + "." + scoreName +"'"); ResultSet rs = ps.executeQuery();
	 * String result = null; if(rs.next()){ result = rs.getString(1); if(result
	 * != null){ result = result.replaceAll(" ", "");//to support var name like
	 * "registered capital" } } ps.close(); return result; } catch (Exception
	 * ex) { log.error("Problem calculating details count of an Invoice", ex);
	 * // You can throw any runtime exception here throw new
	 * SystemException(ex); } finally { try { con.close(); } catch (Exception
	 * ex) { } } }
	 */

}
