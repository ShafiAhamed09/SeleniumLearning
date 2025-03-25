package Learning.com;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts 
{

	public static void main(String[]args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new  ChromeOptions();
		HashMap <String, Integer> content = new HashMap<String,Integer>();
		HashMap <String, Object>  profile = new HashMap<String,Object>();
		HashMap <String, Object> prefs = new HashMap<String,Object>();
		
		
		
		content.put("notifications", 0);
		profile.put("managed_default_content_settings", content);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);
		
		//options.addArguments("disable-notifications");
		WebDriver driver= new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		Thread.sleep(3000);
//		Alert alert= driver.switchTo().alert();
//		
//		alert.dismiss();
		
		
		
	}
	
	
}
