package AllSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webtables {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 

	{
		ChromeOptions options  = new ChromeOptions();
	
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.letskodeit.com/");
		 driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
		 
		 List<WebElement> suggestions= driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-left']//li/a"));
		 for(WebElement suggestion: suggestions)
		 {
			 System.out.println(suggestion.getText());
			 if(suggestion.getText().equalsIgnoreCase("Element Practice"))
			 {
				 suggestion.click();
				 break;
			 }
		 }
		 
		 
		 Thread.sleep(3000);
		 
		 List<String> windowHandles = driver.getWindowHandles().stream().toList();
		 
		 System.out.println(windowHandles.size());

		// Switch to the new tab (last handle)
		driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));

		// Now Selenium is in the Practice Page tab
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		 try {
		 WebDriverWait  wait= new WebDriverWait(driver,Duration.ofSeconds(3000));
		 WebElement table = driver.findElement(By.id("product"));
		 wait.until(ExpectedConditions.visibilityOf(table));
		 
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true)", table);
		 
		 Thread.sleep(3000);
		 
		
		// List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']//tr"));
		 List<WebElement> rows = table.findElements(By.tagName("tr"));
		 System.out.println("totalrows " +rows.size());
		// List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']//tr"));
		 //System.out.println("Total rows: " + rows.size());

		 // Start from i=1 because row[0] is usually the header
		for (int i = 1; i < rows.size(); i++) {
		     List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

		     // Defensive check (skip if row has no <td>, e.g., header/footer)
		     if (cols.size() >= 3) {
		         String courseName = cols.get(0).getText();  // Course name column
		         String courseCategory = cols.get(1).getText();
		         String price = cols.get(2).getText();       // Price column

		         if (courseName.contains("Java")) {
		             System.out.println("Course: " + courseName);
		             System.out.println("Category: " + courseCategory);
		             System.out.println("Price: " + price);
		             break;
		         }
		     }
		 }
		/* List<WebElement> cols = driver.findElements(By.xpath("//table[@id='product']//tr//td"));
		
		 
		 for(int i =1;i<rows.size();i++)
		 {
			 
			String CourseName = cols.get(1).getText();
			if(CourseName.contains("Java"))
			{
				String price= cols.get(2).getText();
			
				 System.out.println(price);
				 break;
			}
			
		 }*/
		
		/* for (int i = 0; i < rows.size(); i++) {
	            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
	            for (WebElement col : cols) {
	               // System.out.print(col.getText() + " | ");
	                if(col.getText().contains("Java")) {
	                	System.out.println(col.getText() + " | ");
	                }
	            }
	           
	        }*/
		/*WebElement fourthRow = rows.get(3);
		 List<WebElement> cols = fourthRow.findElements(By.tagName("td"));
		 for(WebElement colValue:cols)
		 {
			 System.out.println(colValue.getText() + " |");
		 }*/
		
		 
		 
		 }
		 catch(Exception e) {
			 System.out.println("Execetion stopped");
		 }
		 
		 driver.quit();
		 
	}

}
