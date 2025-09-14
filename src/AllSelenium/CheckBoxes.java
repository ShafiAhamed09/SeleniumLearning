package AllSelenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxes {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.letskodeit.com/");
		driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();

		List<WebElement> suggestions = driver
				.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-left']//li/a"));
		for (WebElement suggestion : suggestions) {
			System.out.println(suggestion.getText());
			if (suggestion.getText().equalsIgnoreCase("Element Practice")) {
				suggestion.click();
				break;
			}
		}
		List<String> windowHandles = driver.getWindowHandles().stream().toList();
		// List<String> windowHandles = driver.getWindowHandles().stream().toList();
		driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//checkBOX
		WebElement bmwCheck = driver.findElement(By.id("bmwcheck"));
		wait.until(ExpectedConditions.visibilityOf(bmwCheck));
		bmwCheck.click();
		System.out.println(bmwCheck.isSelected());
		
		WebElement radioButton= driver.findElement(By.xpath("//input[@id='bmwradio']"));
		radioButton.click();
		System.out.println(radioButton.isSelected());
		takesScreenshot("RadioCheckBoxes");
		
		driver.quit();

	}
	
	public static void takesScreenshot(String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp= new SimpleDateFormat("yyMMdd_HHmmSS").format(new Date());
		File dest = new File("./screenshot/"+fileName+"_"+timeStamp+".png");
		FileUtils.copyFile(src, dest);
		System.out.println("RadioBax"+dest.getAbsolutePath());
		
	}

}
