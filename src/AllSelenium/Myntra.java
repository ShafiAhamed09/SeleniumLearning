package AllSelenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
	
		// TODO Auto-generated method stub
		driver=  new ChromeDriver();
		driver.manage().window().maximize();
		String Url="https://Myntra.com/";
		driver.get("https://Myntra.com/");
		String  title =driver.getTitle();
		System.out.println(title);
		
		/* using Search bar */
		/*WebElement search =driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		search.sendKeys("Shoes");
		
		Actions action=new Actions(driver);
		action.sendKeys(search, "Shoes").sendKeys(Keys.ENTER).build().perform(); 
		try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        List<WebElement> suggestions = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.xpath("//ul[@class='desktop-group']"))
	        );

	        // Print all suggestions
	        for (WebElement suggestion : suggestions) {
	            System.out.println(suggestion.getText());
	            if (suggestion.getText().equalsIgnoreCase("apple")) {
	                suggestion.click(); // Click desired suggestion
	                break;
	            }
	        }
		}
		catch(Exception e) {
			
			 System.out.println("⚠️ Suggestions not found or could not be clicked. Continuing execution..");
			
		}*/
		
		//div[@class='desktop-navLink']//div[@data-group='men']//a[contains(text(),'Topwear')]
		
		WebElement navBar= driver.findElement(By.xpath("//a[@data-group='men']"));
		Actions action = new Actions(driver);
		action.moveToElement(navBar).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
		WebElement menDropDown = driver.findElement(By.xpath("//div[@class='desktop-navLink']//div[@data-group='men']//a[contains(text(),'Topwear')]"));
		wait.until(ExpectedConditions.visibilityOf(menDropDown));
		menDropDown.click();
		
		Thread.sleep(3000);
		takesScreenshot("mendropDown");
		
		driver.quit();
		
		
			
					
			
	

	}
	
	public static void takesScreenshot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File desc = new File("./screenshot/"+fileName+"_"+timeStamp+".png");
		FileUtils.copyFile(src, desc);
		System.out.println("ScreenShot Saved: "+desc.getAbsolutePath());
		
		
	}

}
