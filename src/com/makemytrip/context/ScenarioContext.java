package com.makemytrip.context;

import java.util.HashMap;
import java.util.Map;

import com.makemytrip.enums.Context;
import com.makemytrip.utilities.Log;

public class ScenarioContext {

private Map<String,Object> scenarioContext;
	
	public ScenarioContext() {
		scenarioContext=new HashMap<String, Object>();
	}
	
	public void setContext(Context key,Object value) {
		Log.info("Setting Context:"+key);
		scenarioContext.put(key.toString(), value);
		Log.info("Pass:Context has set with key:"+key+" and value:"+value);
	}
	
	public Object getContext(Context key) {
		return scenarioContext.get(key.toString());
	}
	
	public boolean isContains(Context key) {
		return scenarioContext.containsKey(key.toString());
	}
}
