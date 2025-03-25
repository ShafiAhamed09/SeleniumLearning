package Learning.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FBDriverLauch {

	public static void main(String[] args) throws InterruptedException 
	{
	
		// TODO Auto-generated method stub
		ChromeOptions options =new ChromeOptions();
		options.addArguments("Start-maximized");
		
		//WebDriver driver = new ChromeDriver(options);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		WebElement Signupbutton = driver.findElement(By.xpath("//a[@*='open-registration-form-button']"));
		Signupbutton.click();
		Thread.sleep(3000);
		WebElement Firstname= driver.findElement(By.xpath("//input[@name='firstname']"));
		Firstname.sendKeys("aaa");
		WebElement Surname =driver.findElement(By.xpath("//input[@name='lastname']"));
		Surname.sendKeys("zzz");
		
		WebElement selectday = driver.findElement(By.id("day"));
		Select selectDayDropdown = new Select(selectday);
		selectDayDropdown.selectByValue("9");
		
		WebElement selectMonth =driver.findElement(By.xpath("//select[@id='month']"));
		Select selectMonthDropdown= new Select(selectMonth);
		selectMonthDropdown.selectByVisibleText("Apr");
		Thread.sleep(3000);
		
		WebElement selectYear =driver.findElement(By.xpath("//select[@id='year']"));
		Select selectYearDropdown= new Select(selectYear);
		selectYearDropdown.selectByVisibleText("1996");
		Thread.sleep(3000);
		
		WebElement Genderselection = driver.findElement(By.xpath("//label[contains(.,'Male')]"));
		Genderselection.click();
		Thread.sleep(3000);
		
		WebElement MailId=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		MailId.sendKeys("SSA@gamil.com");
		Thread.sleep(3000);
		driver.quit();
		
		WebElement MailIdConfrimation =driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		MailIdConfrimation.sendKeys("SSA@gamil.com");
		Thread.sleep(3000);
		driver.quit();
		
		
		
	 
		
	}

}

