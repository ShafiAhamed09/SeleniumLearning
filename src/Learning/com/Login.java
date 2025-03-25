package Learning.com;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class Login {

	public static  void main(String[] args) throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		ChromeOptions options =new ChromeOptions();
		options.addArguments("Start-maximized");
		
		//WebDriver driver = new ChromeDriver(options);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.confirmtkt.com/rbooking-d/");
		Thread.sleep(3000);
		WebElement LoginButton = driver.findElement(By.xpath("//*[@class='MuiListItem-root jss2 MuiListItem-gutters']"));
		LoginButton.click();
		Thread.sleep(3000);
		WebElement MobileNumber = driver.findElement(By.xpath("//input[@id='mobile-number']"));
		MobileNumber.sendKeys("9902850784");
		Thread.sleep(3000);
		WebElement SendOTP = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained ctkt-btn-success zero-border-radius']"));
		//SendOTP.click();
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot) driver; //typecasted 
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		//File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//File sourceFile = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File(".\\Screenshots\\img1.png");
		FileHandler.copy(src, destFile);
		driver.close();
		
		
		
		

	}

}
