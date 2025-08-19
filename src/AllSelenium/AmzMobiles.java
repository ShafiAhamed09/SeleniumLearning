package AllSelenium;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
/*7. Automation scenario:
 * Open Amazon
 * Search for mobiles
 * Scroll twice
 * Find the XPath of the 7th listed mobile (generic XPath that works even in a new tab).*/


public class AmzMobiles {
	 public static void main(String[] args) throws InterruptedException {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
	        WebDriver driver = new ChromeDriver(options);

	        driver.manage().window().maximize();
	        driver.get("https://www.amazon.in");

	        // Search for mobiles
	        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
	        search.sendKeys("Mobiles", Keys.ENTER);

	        // Wait until results are visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@data-component-type='s-search-result'])[7]")));

	        // Scroll down twice
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1000)");
	        js.executeScript("window.scrollBy(0,1000)");

	        // Find the 7th listed mobile
	        WebElement seventhMobile = driver.findElement(By.xpath("(//div[@data-component-type='s-search-result'])[5]//h2//span"));
	        String mobileName=seventhMobile.getText();
	        System.out.println(mobileName);
	        seventhMobile.click();
	      //  WebElement title = seventhMobile.findElement(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));

	        // Print the 7th mobile title
	       // System.out.println("7th Mobile: " + title.getText());
	        Thread.sleep(3000);

	        driver.quit();
	    }

}
