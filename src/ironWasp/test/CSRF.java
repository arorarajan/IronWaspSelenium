package ironWasp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import rest.impl.IronWasp;
/*
 * XSS Reflected - Pen Test Tool Lookup
 */
public class CSRF {

	public static void main(String args[]) {
		IronWasp.startIronWaspLog();
		
		FirefoxProfile profile = new FirefoxProfile();  
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", "localhost");
		profile.setPreference("network.proxy.http_port", 8081);
		profile.setPreference("network.proxy.ssl", "localhost");
		profile.setPreference("network.proxy.ssl_port", 8081);
		profile.setPreference("network.proxy.no_proxies_on","");
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://127.0.0.1/mutillidae/index.php?page=pen-test-tool-lookup.php");
		
		Select select = new Select(driver.findElement(By.id("idToolSelect")));
		select.selectByValue("1");
		driver.findElement(By.name("pen-test-tool-lookup-php-submit-button")).click();;
		
		String source = driver.getPageSource();
		if (source.contains("WebSecurify")) {
			System.out.println("Tool loaded");
		}
		else
			System.out.println("Tool not loaded, run again");
		driver.close();
		IronWasp.endIronWaspLog();
	}	
}
