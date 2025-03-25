package AllSelenium;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOps {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");  // runs the browser in the background
		options.addArguments("--start-maximized");
		// options.addArguments("disable-notifications"); // disable the notifications
		options.addArguments("--no-sandbox");
		
		/* to allow , block & disable the popups like notifications, geolocations etc to disables--0,to allow-->1, to block-2, */
		HashMap<String, Integer> content = new HashMap<String, Integer>();
		HashMap<String, Object> profile = new HashMap<String, Object>();
		HashMap<String, Object> prefs = new HashMap<String, Object>();

		content.put("notifications", 2);
		profile.put("managed_default_content_settings", content);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		// driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);

//		TakesScreenshot ts = (TakesScreenshot) driver; //typecasted 
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		
//		//File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		//File sourceFile = driver.getScreenshotAs(OutputType.FILE);
//		File destFile = new File(".\\Screenshots\\img1.png");
//		FileHandler.copy(src, destFile);
//		
		// driver.quit();

	}

}
