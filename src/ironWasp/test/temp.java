package ironWasp.test;

import java.util.HashMap;

import rest.impl.IronWasp;

public class temp {

	public static void main(String args[]) {
		/*String className = new Exception().getStackTrace()[1].getClassName();
		System.out.println(className);*/
		IronWasp.endIronWaspLog();
	}
	
	  public static void startIronWaspLog(HashMap<String, String> params) {
		HashMap<String, String> finalParams = new HashMap();
		//finalParams.putAll(map);
		finalParams.putAll(params);
       
	}
}
