package ironWasp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import rest.impl.IronWasp;
/*
 * Login
 */
public class Login {

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
		
		driver.get("http://127.0.0.1/mutillidae/index.php?page=login.php");
		
		driver.findElement(By.name("username")).sendKeys("ironWaspTest");
		driver.findElement(By.name("password")).sendKeys("test");
		driver.findElement(By.name("login-php-submit-button")).click();;
		
		if (driver.getCurrentUrl().contains("http://127.0.0.1/mutillidae/index.php?popUpNotificationCode=AU1")) {
			System.out.println("Logged in");
		}
		else
			System.out.println("Not Logged in, run again");
		driver.close();
		IronWasp.endIronWaspLog();
	}	
}
