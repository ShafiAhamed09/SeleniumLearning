package Amazon;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignIN {


	
	 public static void main(String[]args) throws InterruptedException, IOException 
	 {
		 
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions options= new ChromeOptions();
		 options.addArguments("--incognito");
		 options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		 options.setExperimentalOption("useAutomationExtension", false);
		 
		 WebDriver driver = new ChromeDriver(options);
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.in");
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		 WebElement continueShopping=driver.findElement(By.xpath("//button[contains(text(),'Continue shopping')]"));
		 wait.until(ExpectedConditions.visibilityOf(continueShopping));
		 continueShopping.click();
		
		 Thread.sleep(3000);
		 System.out.println(driver.findElement(By.xpath("//span[text()='Hello, sign in']")).getText());
		 driver.findElement(By.xpath("//a[@aria-labelledby='Account & Lists']")).click();
		 utils.utils.commonScreenshot(driver, "img3.png");
		  
		 Thread.sleep(3000);
		 
		 driver.navigate().back();
		 
		 driver.findElement(By.id("nav-hamburger-menu")).click();
		 
		utils.utils.commonScreenshot(driver, "img4.png");
		
		
		
		    
		//Assert.assertTrue(driver.findElement(null))
		Thread.sleep(3000);
		 driver.quit();
		 
	 }
}
