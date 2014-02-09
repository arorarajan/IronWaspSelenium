package ironWasp.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import rest.impl.IronWasp;
/*
 * Arbitrary File Inclusion
 */
public class ArbitaryFileIncludion {

	public static void main(String args[]) throws InterruptedException {
		IronWasp.startIronWaspLog();
		
		FirefoxProfile profile = new FirefoxProfile();  
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", "localhost");
		profile.setPreference("network.proxy.http_port", 8081);
		profile.setPreference("network.proxy.ssl", "localhost");
		profile.setPreference("network.proxy.ssl_port", 8081);
		profile.setPreference("network.proxy.no_proxies_on","");
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://127.0.0.1/mutillidae/index.php?page=arbitrary-file-inclusion.php");
		String source = driver.getPageSource();
		if (source.contains("Arbitrary File Inclusion")) {
			System.out.println("Page loaded");
		}
		else
			System.out.println("Page not loaded, run again");
		driver.close();
		IronWasp.endIronWaspLog();
	}	
}
