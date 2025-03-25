package Learning.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class title {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.confirmtkt.com/rbooking-d/");
//METHOD1
		String Title = driver.getTitle();
		System.out.println(Title);
		
		//METHOD2
		String url =driver.getCurrentUrl();
		System.out.println(url);
		
		//METHOD3
		String pagesource =driver.getPageSource();
		System.out.println(pagesource);
		
		Thread.sleep(3000);
		driver.quit();
		
	

	}

}
