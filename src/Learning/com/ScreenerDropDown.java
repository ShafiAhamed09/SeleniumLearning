package Learning.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenerDropDown {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		JavascriptExecutor js;

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.screener.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loggingIN(driver);
		Thread.sleep(3000);
		enteringStockName(driver);
		Thread.sleep(3000);
		navigationBar(driver);

		// utils.utils.commonScreenshot(driver, img.png);

	}

	private static void loggingIN(WebDriver driver)
 {
		// TODO Auto-generated method stub
		WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login/?']"));
		loginButton.click();
		WebElement eMail = driver.findElement(By.xpath("//input[@name='username']"));
		eMail.sendKeys("shafiahamad222@gmail.com");
		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys("Shascr@784");
		WebElement Login = driver.findElement(By.xpath("//button[@type='submit']"));
		Login.click();
	}

	private static void enteringStockName(WebDriver driver) 
{
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("(//input[@aria-label=\"Search for a company\"])[last()]")).sendKeys("tata");
		List<WebElement> suggestion = driver.findElements(By.xpath("//ul[@class='dropdown-content visible']//li"));
		for (WebElement eachElement : suggestion) {
			String text = eachElement.getText();
			System.out.println(text);

			if (text.equalsIgnoreCase("Tata Technologies Ltd")) {
				//				System.out.println(text); 
				//				Actions a=new Actions(driver);
				//				a.moveToElement(each)
				eachElement.click();
			} else {
				System.out.println("No");
			}

		}

	}
	
	private static void navigationBar(WebDriver driver)
	{
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement chart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Chart']")));
		chart.click();

	}
}

