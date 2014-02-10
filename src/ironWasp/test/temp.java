package ironWasp.test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import rest.impl.IronWasp;

public class temp {

	public static void main(String args[]) {
		IronWasp.workflowStart();
		FirefoxProfile profile = new FirefoxProfile();  
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", IronWasp.ipAddress);
		profile.setPreference("network.proxy.http_port", IronWasp.portNumber);
		profile.setPreference("network.proxy.ssl", IronWasp.ipAddress);
		profile.setPreference("network.proxy.ssl_port", IronWasp.portNumber);
				
		profile.setPreference("network.proxy.no_proxies_on","");
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://127.0.0.1/mutillidae/index.php?page=arbitrary-file-inclusion.php");
			
		IronWasp.workflowEnd();
		IronWasp.showStartRequest();
	}

}
