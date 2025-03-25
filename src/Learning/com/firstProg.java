package Learning.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;

public class firstProg {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver():
		System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
	/*	WebDriver driver = new ChromeDriver();
		
		//Way1 to Maximize the window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.confirmtkt.com/rbooking-d/");
		Thread.sleep(10000);*/
		
		//Way2
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(options);
		Thread.sleep(5000);
		driver.get("https://www.confirmtkt.com/rbooking-d/");

		driver.quit();

	}

}

/*NOTE: In this program we have learnt how to launch the chromebrowser & maximize it in 2 ways */
