package ironWasp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import rest.impl.IronWasp;
/*
 * Unvalidated Redirects and forwards
 */
public class Redirects {

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
		
		driver.get("http://127.0.0.1/mutillidae/index.php?page=credits.php");
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]/blockquote/div[7]/a")).click();
		
		if (driver.getCurrentUrl().contains("owasp.org")) {
			System.out.println("redirected");
		}
		else
			System.out.println("Not redirected, run again");
		driver.close();
		IronWasp.workflowEnd();
	}	
}
