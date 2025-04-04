package Learning.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductsAndPrices 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"} );
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");
		/*
		 * WebElement searchTextField =
		 * driver.findElement(By.xpath("//input[@type='text']"));
		 * searchTextField.sendKeys("mobile"); List<WebElement> searchDropDown =
		 * driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']//li"));
		 * for(WebElement searchDropDownList:searchDropDown) {
		 * System.out.println(searchDropDownList); }
		 */
		  WebElement fashionHovering = driver.findElement(By.xpath("//span[text()='Fashion']"));
		  Actions action = new Actions(driver);
		  action.moveToElement(fashionHovering).perform();
		  WebElement fashionDropDownListElement= driver.findElement(By.xpath("//div[@class='_16rZTH']//a[contains(text(),'Top Wear')]"));
		  fashionDropDownListElement.click();
		//Locating element by link text and store in variable "Element"        		
	        WebElement Element = driver.findElement(By.xpath("//div[text()='Gender']"));
	        
	        JavascriptExecutor js =(JavascriptExecutor) driver;

	        // Scrolling down the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView()",Element);
	        
	        WebElement min_slider = driver.findElement(By.xpath("//div[contains(@class,'Oyj7AF')]/div[1]"));
	        WebElement max_slider = driver.findElement(By.xpath("//div[contains(@class,'Oyj7AF')]/div[2]"));
	        
	      //  action.dragAndDropBy(min_slider, 50, 0).perform();
	      //  action.dragAndDropBy(max_slider, -50, 0).perform();
            action.clickAndHold(min_slider).moveByOffset(100, 0).release().perform();
	        Thread.sleep(3000);
	        action.clickAndHold(max_slider).moveByOffset(-50, 0).release().perform();
	        Thread.sleep(3000);
	        WebElement lowToHigh = driver.findElement(By.xpath("//div[@class='zg-M3Z _0H7xSG']"));
	        action.moveToElement(lowToHigh).click();
	        Thread.sleep(3000);
	        List<WebElement>  products = driver.findElements(By.xpath("//div[@class='syl9yP']"));
	        List<WebElement>  prices= driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
	        //String price="";
	       // System.out.println(products.toString());
	        if (products.size()==prices.size())
	        {
	        	for(int i=0;i<products.size();i++)
	        	{
	        		String productName= products.get(i).getText();
	        		String productPrices= prices.get(i).getText();
	        		
	        		System.out.println(productName+ " "+productPrices);
	        	}
	        }	
	        driver.quit();
	}
}
