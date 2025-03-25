package Learning.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stu
		ChromeOptions options =new ChromeOptions();
		options.addArguments("Start-maximized");
		
		//WebDriver driver = new ChromeDriver(options);
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(3000);
		
		WebElement CourseName=driver.findElement(By.xpath("//select[@id='course']"));
		Select selectDropDown=new Select(CourseName);
		List<WebElement> selectDropDownOptions =selectDropDown.getOptions();
		for (WebElement options1 : selectDropDownOptions) 
		{ 
			System.out.println(options1.getText());
		}
		
		selectDropDown.selectByValue("java");
		Thread.sleep(3000);
		selectDropDown.selectByIndex(4);
		Thread.sleep(3000);
		selectDropDown.selectByVisibleText("Dot Net");
		Thread.sleep(3000);
		
		System.out.println(selectDropDown.getFirstSelectedOption().getText());
		List<WebElement> SelectedOptions=selectDropDown.getAllSelectedOptions();
		for (WebElement options2 : SelectedOptions) 
		{ 
			System.out.println(options2.getText());
		}
		
		//we can select the multiple options in the dropdown by using the below method
		

		WebElement multipleCourseName=driver.findElement(By.xpath("//select[@id='ide']"));
		Select mutliselectDropDown=new Select(multipleCourseName);
		List<WebElement> multiselectDropDownOptions = mutliselectDropDown.getOptions();
		for (WebElement options3 : multiselectDropDownOptions) 
		{ 
			System.out.println(options3.getText());
		}
		
		mutliselectDropDown.selectByVisibleText("Eclipse");
		Thread.sleep(3000);
		mutliselectDropDown.selectByVisibleText("IntelliJ IDEA");
		mutliselectDropDown.selectByValue("vs");
		
		List<WebElement> multiSelectedOptions=mutliselectDropDown.getAllSelectedOptions();
		for (WebElement options3 : multiSelectedOptions) 
		{ 
			System.out.println("Multiple selected IDEs  " +options3.getText());
		}
		
		mutliselectDropDown.deselectByValue("vs");
		
		driver.close();
		
	}

}
