package AllSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null; // Declare driver outside the if-else block to avoid scope issues.
//Cross browser
        String browser = "chrome"; // Specify the browser type.
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("No valid browser specified!");
            System.exit(0); // Exit the program if no browser is specified.
        }

        driver.manage().window().maximize();
        driver.get("https://www.screener.in");
        String StockName= "Tata Motors Ltd";
        // Search functionality
        driver.findElement(By.xpath("//div[@class='home-search']/div/input")).click();
         driver.findElement(By.xpath("//div[@class='home-search']/div/input")).sendKeys(StockName);
        Thread.sleep(3000);
        List<WebElement> dropDownLists =driver.findElements(By.xpath("//ul[@class='dropdown-content visible']//li"));
          for(WebElement stockNameFromDD: dropDownLists)
          {
        	  String text = stockNameFromDD.getText();
//  			System.out.println(text);

        	  System.out.println(text);
        	  if(stockNameFromDD.getText().equalsIgnoreCase(StockName));
        	  {
        		  stockNameFromDD.click();
        		  break;
        	  }
          }
          Thread.sleep(3000);
		/*
		 * // Using JavaScriptExecutor to interact with the page JavascriptExecutor js =
		 * (JavascriptExecutor) driver;
		 * js.executeScript("alert('Search executed successfully!');");
		 * 
		 */        // Close the browser after execution
        driver.quit();
    }
}