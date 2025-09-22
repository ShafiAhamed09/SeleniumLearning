package AllSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframes {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.findElement(By.id("name")).sendKeys("shafi");
		
	//	WebElement frame=driver.findElement(By.id("frm1"));
		
		 driver.switchTo().frame("frm1");
		
		 WebElement droplist=driver.findElement(By.id("selectnav2"));
		 Select selectFromDropDown = new Select(droplist);
		 selectFromDropDown.selectByVisibleText("Menu");
		 
		 WebElement droplist2=driver.findElement(By.id("selectnav1"));
		 Select secondDropDown= new Select(droplist2);
		 secondDropDown.selectByIndex(5);
		 
		 driver.switchTo().defaultContent();
		 driver.findElement(By.id("name")).sendKeys(" ahamed");
		 Thread.sleep(5000);
		 driver.quit();

	}

}
