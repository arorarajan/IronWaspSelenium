package ironWasp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import rest.impl.IronWasp;
/*
 * CSRF- Add to tour blog
 */
public class XSSReflected {

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
		
		driver.get("http://127.0.0.1/mutillidae/index.php?page=add-to-your-blog.php");
		
		/*String source = driver.getPageSource();
		if (source.contains("Arbitrary File Inclusion")) {
			System.out.println("Page loaded");
		}
		else
			System.out.println("Page not loaded, run again");*/
		driver.close();
		IronWasp.workflowEnd();
	}	
}
