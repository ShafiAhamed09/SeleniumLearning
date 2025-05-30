package Learning.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisableAutomationMessage {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		
		/* excludeSwitches is a capability provide by the chrome options to manage the Switches  */
		
        options.setExperimentalOption("useAutomationExtension", false);
        /*is used in Selenium WebDriver when configuring a ChromeOptions object.
         *  It disables the Chrome Automation Extension, 
         *  which is a built-in extension that Chrome adds when running in automated mode.*/
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        driver.get("https://www.google.com/");

	}

}
