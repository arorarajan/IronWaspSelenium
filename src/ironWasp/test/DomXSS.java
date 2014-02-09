package ironWasp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import rest.impl.IronWasp;
/*
 * DOM XSS - HTML 5 Storage
 */
public class DomXSS {

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
		
		driver.get("http://127.0.0.1/mutillidae/index.php?page=html5-storage.php");
		
		driver.findElement(By.id("idDOMStorageKeyInput")).sendKeys("IronWaspKey");
		driver.findElement(By.id("idDOMStorageItemInput")).sendKeys("IronWaspItem");
		driver.findElement(By.xpath("//*[@id=\"idForm\"]/table[2]/tbody[3]/tr[2]/td[4]/input")).click();;
		
		String source = driver.getPageSource();
		if (source.contains("Added key IronWaspKey to Session storage")) {
			System.out.println("Key added");
		}
		else
			System.out.println("key not added, run again");
		driver.close();
		IronWasp.endIronWaspLog();
	}	
}
