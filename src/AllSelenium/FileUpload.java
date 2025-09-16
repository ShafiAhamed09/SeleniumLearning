package AllSelenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;

public class FileUpload {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		HashMap<String,Object>  Chromeprefs = new HashMap<>();
		//Chromeprefs.put("plugins.always_open_pdf_externally", true);
		Chromeprefs.put("download.defaultdirectory","./downloads");
		options.setExperimentalOption("prefs", Chromeprefs);
	
		 driver = new ChromeDriver(options);
		 
		 driver.manage().window().maximize();
		 driver.get("https://samplelib.com/");
		 driver.findElement(By.xpath("//a[text()='XLS']")).click();
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		 WebElement download = driver.findElement(By.xpath("//div[@class='row justify-content-center align-items-center']//a[1]"));
		 wait.until(ExpectedConditions.visibilityOf(download));
		 
		 download.click();
		 
		 Thread.sleep(10000);
		 
		 driver.quit();
		

	}

}
